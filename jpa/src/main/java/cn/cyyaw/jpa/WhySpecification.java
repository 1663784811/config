package cn.cyyaw.jpa;

import cn.cyyaw.common.util.ArrayUtils;
import cn.cyyaw.common.util.DateUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * jsonStr 格式
 *
 * @param <T>
 */
@Slf4j
public class WhySpecification<T> implements Specification<T> {
    /**
     * json查询条件
     */
    private String jsonStr;
    /**
     * 允许查询的数组
     */
    private String[] columnArr;
    /**
     * 条件描述对象
     */
    private Predicate pred = null;
    /**
     * 查询条件
     *
     * @param jsonStr   查询字符串
     * @param columnArr 允许查询条件
     */
    public WhySpecification(String jsonStr, String... columnArr) {
        this.jsonStr = jsonStr;
        this.columnArr = columnArr;
    }


    /**
     * 转换成条件描述对象
     *
     * @param root  查询根对象
     * @param query 查询对象
     * @param cb    标准查询构造器
     * @return
     */
    public Predicate toPredicate(final Root<T> root, final CriteriaQuery<?> query, final CriteriaBuilder cb) {
        // 判断pred是否为空，分页查询时调用了两次该方法，不判断的话会被执行两次
        if (pred != null) {
            return pred;
        }
        if (null == jsonStr || jsonStr.length() == 0) {
            return null;
        }
        return getZuHeChaXunPredicate(root, query, cb, jsonStr);
    }

    /**
     * 获取组合查询的Predicate
     *
     * @param root    查询根对象
     * @param query   查询对象
     * @param cb      标准查询构造器
     * @param jsonStr 组合查询的条件json
     * @return the zu he cha xun predicate
     */
    public final Predicate getZuHeChaXunPredicate(final Root<T> root, final CriteriaQuery<?> query, final CriteriaBuilder cb, final String jsonStr) {
        HashMap<String, Object> mapChaXun = JSON.parseObject(jsonStr, HashMap.class);
        // 如果转换的json对象为空或长度为0，则退出
        if (mapChaXun == null || mapChaXun.size() == 0) {
            return null;
        }
        pred = jsonPredicate(root, cb, jsonStr, null);
        return pred;
    }


    /**
     * 递归实现 ，json数据解释，Predicate组装
     *
     * @return
     */
    public Predicate jsonPredicate(final Root<T> root, final CriteriaBuilder cb, String jsonStr, String type) {
        //解释json
        HashMap<String, Object> mapjson = JSON.parseObject(jsonStr, HashMap.class);
        List<Predicate> predicateList = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Object> entry : mapjson.entrySet()) {
            String keyArr[] = entry.getKey().split("_");
            if (keyArr.length == 3) {
                //  and_string_accound
                Predicate p = null;
                if (null == columnArr || columnArr.length == 0 || ArrayUtils.isStr(keyArr[2], columnArr)) {
                    p = getPredicate(root, cb, keyArr[0], keyArr[1], keyArr[2], entry.getValue().toString());
                }
                if (null != p) {
                    predicateList.add(p);
                }
            } else {
                if (keyArr.length == 1) {
                    // and:{}
                    Predicate predicate1 = jsonPredicate(root, cb, entry.getValue().toString(), keyArr[0]);
                    if (null != predicate1) {
                        predicateList.add(predicate1);
                    }
                }
            }
            i++;
        }

        if (null != predicateList && predicateList.size() > 0) {
            Predicate[] predicates = new Predicate[predicateList.size()];
            if (null != type && type.toLowerCase().equals("or")) {
                return cb.or(predicateList.toArray(predicates));
            } else {
                return cb.and(predicateList.toArray(predicates));
            }
        } else {
            return null;
        }
    }


    /**
     * @param root
     * @param cb
     * @param wheres  条件
     * @param types   类型
     * @param columns 字段
     * @param value   值
     * @return
     */
    private Predicate getPredicate(final Root<T> root, final CriteriaBuilder cb, final String wheres, final String types, final String columns, String value) {
        String column = columns.toLowerCase();
        String type = types.toLowerCase();
        String where = wheres.toLowerCase();
        pred = null;
        Date date = null;
        switch (where) {
            case "likeleft":
                switch (type) {
                    case "string":
                        pred = cb.like(root.get(column).as(String.class), value + "%");
                        break;
                }
                break;
            case "likeright":
                switch (type) {
                    case "string":
                        pred = cb.like(root.get(column).as(String.class), "%" + value);
                        break;
                }
                break;
            case "like":
                switch (type) {
                    case "string":
                        pred = cb.like(root.get(column).as(String.class), "%" + value + "%");
                        break;
                }
                break;
            case "notequals":
                switch (type) {
                    case "integer":
                        pred = cb.notEqual(root.get(column).as(Integer.class), Integer.valueOf(value));
                        break;
                    case "float":
                        pred = cb.notEqual(root.get(column).as(Float.class), Float.valueOf(value));
                        break;
                    case "double":
                        pred = cb.notEqual(root.get(column).as(Double.class), Double.valueOf(value));
                        break;
                    case "date":
                        pred = cb.notEqual(root.get(column).as(Date.class), DateUtils.getDate(value));
                        break;
                    case "string":
                        pred = cb.notEqual(root.get(column).as(String.class), value);
                        break;
                }
                break;
            case "equals":
                switch (type) {
                    case "integer":
                        pred = cb.equal(root.get(column).as(Integer.class), Integer.valueOf(value));
                        break;
                    case "float":
                        pred = cb.equal(root.get(column).as(Float.class), Float.valueOf(value));
                        break;
                    case "double":
                        pred = cb.equal(root.get(column).as(Double.class), Double.valueOf(value));
                        break;
                    case "date":
                        pred = cb.equal(root.get(column).as(Date.class), date);
                        break;
                    case "string":
                        pred = cb.equal(root.get(column).as(String.class), value);
                        break;
                    /*case "strings":
                        doShuZuTiaoJian(root, cb, strzhi, strziduan);
                        break;
                    case "integers":
                        doShuZuTiaoJian(root, cb, strzhi, strziduan);
                        break;*/
                }
                break;
            case "ge":
                switch (type) {
                    case "integer":
                        pred = cb.ge(root.get(column).as(Integer.class), Integer.valueOf(value));
                        break;
                    case "float":
                        pred = cb.ge(root.get(column).as(Float.class), Float.valueOf(value));
                        break;
                    case "double":
                        pred = cb.ge(root.get(column).as(Double.class), Double.valueOf(value));
                        break;
                    case "date":
                        pred = cb.greaterThanOrEqualTo(root.get(column).as(Date.class), date);
                        break;
                }
                break;
            case "gt":
                switch (type) {
                    case "integer":
                        pred = cb.gt(root.get(column).as(Integer.class), Integer.valueOf(value));
                        break;
                    case "float":
                        pred = cb.gt(root.get(column).as(Float.class), Float.valueOf(value));
                        break;
                    case "double":
                        pred = cb.gt(root.get(column).as(Double.class), Double.valueOf(value));
                        break;
                    case "date":
                        pred = cb.greaterThan(root.get(column).as(Date.class), date);
                        break;
                }
                break;
            case "le":
                switch (type) {
                    case "integer":
                        pred = cb.le(root.get(column).as(Integer.class), Integer.valueOf(value));
                        break;
                    case "float":
                        pred = cb.le(root.get(column).as(Float.class), Float.valueOf(value));
                        break;
                    case "double":
                        pred = cb.le(root.get(column).as(Double.class), Double.valueOf(value));
                        break;
                    case "date":
                        pred = cb.lessThanOrEqualTo(root.get(column).as(Date.class), date);
                        break;
                }
                break;
            case "lt":
                switch (type) {
                    case "integer":
                        pred = cb.lt(root.get(column).as(Integer.class), Integer.valueOf(value));
                        break;
                    case "float":
                        pred = cb.lt(root.get(column).as(Float.class), Float.valueOf(value));
                        break;
                    case "double":
                        pred = cb.lt(root.get(column).as(Double.class), Double.valueOf(value));
                        break;
                    case "date":
                        pred = cb.lessThan(root.get(column).as(Date.class), date);
                        break;
                }
                break;
        }
        return pred;
    }
}
