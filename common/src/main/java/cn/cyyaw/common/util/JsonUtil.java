package cn.cyyaw.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.Set;

public class JsonUtil extends JSON {
    /**
     * 过滤序列化
     */
    public static final String toJSONStringFilter(final Object object, String... filter) {
        if (null != object) {
            if (null != filter) {
                SimplePropertyPreFilter f = new SimplePropertyPreFilter();
                Set<String> excludes = f.getExcludes();
                for (String fstr : filter) {
                    excludes.add(fstr);
                }
                return toJSONString(object, f,SerializerFeature.WriteMapNullValue);
            } else {
                return toJSONString(object, SerializerFeature.WriteMapNullValue);
            }
        }
        return null;
    }

    /**
     * 允许序列化
     */
    public static final String toJSONStringAllow(final Object object, String... filter) {
        if (null != object) {
            if (null != filter) {
                SimplePropertyPreFilter f = new SimplePropertyPreFilter();
                Set<String> includes = f.getIncludes();
                for (String fstr : filter) {
                    includes.add(fstr);
                }
                return toJSONString(object, f,SerializerFeature.WriteMapNullValue);
            } else {
                return toJSONString(object,SerializerFeature.WriteMapNullValue);
            }
        }
        return null;
    }
}
