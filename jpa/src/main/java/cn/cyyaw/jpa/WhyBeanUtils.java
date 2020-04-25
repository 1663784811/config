package cn.cyyaw.jpa;


import cn.cyyaw.common.util.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 处理Bean绑定的工具类
 * <p>
 * 1。对象复制
 */
public final class WhyBeanUtils extends BeanUtils {


    private static final String[] baseType = {
            "short", "class java.lang.Short",
            "int", "class java.lang.Integer",
            "long", "class java.lang.Long",
            "class java.lang.Class",
            "byte", "class java.lang.Byte",
            "boolean", "class java.lang.Boolean",
            "char", "class java.lang.Character",
            "float", "class java.lang.Float",
            "double", "class java.lang.Double",
            "class java.lang.String",
            "class java.util.Date"};


    /**
     * javaBean 转  Map  只能是一层
     *
     * @param bean java Bean
     * @return Map
     */
    public static Map bean2Map(Object bean) {
        Map<String,Object> returnMap = new HashMap<String,Object>();
        if (null != bean) {
            Class type = bean.getClass();
            BeanInfo beanInfo = null;
            try {
                beanInfo = Introspector.getBeanInfo(type);
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                for (int i = 0, n = propertyDescriptors.length; i < n; i++) {
                    PropertyDescriptor descriptor = propertyDescriptors[i];
                    String propertyName = descriptor.getName();
                    if (!propertyName.equals("class") && ArrayUtils.isStr(descriptor.getPropertyType().toString(), baseType)) {
                        Method readMethod = descriptor.getReadMethod();
                        Object result = readMethod.invoke(bean, new Object[0]);
                        if (result != null) {
                            returnMap.put(propertyName, result);
                        } else {
                            returnMap.put(propertyName, "");
                        }
                    }
                }
            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return returnMap;
    }

    /**
     * 带过滤条件的，javaBean 转  Map  只能是一层
     *
     * @param bean     要转换的javabean
     * @param fieldArr 要过滤的属性
     */
    public static Map filterBean2Map(Object bean, String[] fieldArr) {
        Map<String,Object> returnMap = new HashMap<String,Object>();
        if (null != bean) {
            Class type = bean.getClass();
            BeanInfo beanInfo = null;
            try {
                beanInfo = Introspector.getBeanInfo(type);
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                for (int i = 0, n = propertyDescriptors.length; i < n; i++) {
                    PropertyDescriptor descriptor = propertyDescriptors[i];
                    String propertyName = descriptor.getName();
                    if (!propertyName.equals("class") && !ArrayUtils.isStr(propertyName, fieldArr) && ArrayUtils.isStr(descriptor.getPropertyType().toString(), baseType)) {
                        Method readMethod = descriptor.getReadMethod();
                        Object result = readMethod.invoke(bean, new Object[0]);

                        if (result != null) {
                            if (result.getClass().equals(Timestamp.class) || result.getClass().equals(Date.class)) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                returnMap.put(propertyName, simpleDateFormat.format(result));
                            } else {
                                returnMap.put(propertyName, result);
                            }
                        } else {
                            returnMap.put(propertyName, "");
                        }
                    }
                }
            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return returnMap;

    }

    /**
     * 带过滤条件的，javaBean 转  Map  只能是一层
     *
     * @param listBean 要转换的javabean List
     * @param fieldArr 要过滤的属性
     * @return
     */
    public static List<Map> filterListBean2ListMap(List listBean, String[] fieldArr) {
        List<Map> list = new ArrayList<Map>();
        if (null != listBean && listBean.size() > 0) {
            for (int i = 0; i < listBean.size(); i++) {
                list.add(filterBean2Map(listBean.get(i), fieldArr));
            }
        }

        return list;
    }

    /**
     * 分页过虑
     *
     * @param page     Page
     * @param fieldArr 要过滤的属性数组
     */
    public static Map filterPage(Page page, String[] fieldArr) {
        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put("page", page.getPageable().getPageNumber() + 1);
        returnMap.put("size", page.getPageable().getPageSize());
        returnMap.put("total", page.getTotalElements());
        returnMap.put("data", filterListBean2ListMap(page.getContent(), fieldArr));
        return returnMap;

    }


    /**
     * 过滤属性
     *
     * @param bean     要过滤的对象
     * @param fieldArr 要过滤的属性数组
     */
    public static void filterField(Object bean, String[] fieldArr) {
        try {
            Field[] fields = bean.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                if (ArrayUtils.isStr(fields[i].getName(), fieldArr)) {
                    fields[i].set(bean, null);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    /**
     * 复制对象，
     *
     * @param source           原对象
     * @param target           目标对象
     * @param accessProperties 允许复制的属性列表
     */
    public static void copyPropertiesAccess(Object source, Object target, String... accessProperties) {
        Assert.notNull(source, "原对象不能为null");
        Assert.notNull(target, "目标对象不能为null");
        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        List<String> accessList = (accessProperties != null ? Arrays.asList(accessProperties) : null);
        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null && accessList != null && accessList.contains(targetPd.getName())) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null &&
                            ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }
                            Object value = readMethod.invoke(source);
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, value);
                        } catch (Throwable ex) {
                            throw new FatalBeanException(
                                    "Could not copy property '" + targetPd.getName() + "' from source to target", ex);
                        }
                    }
                }
            }
        }
    }


}