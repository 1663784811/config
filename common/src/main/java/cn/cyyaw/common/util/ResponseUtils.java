package cn.cyyaw.common.util;

import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public final class ResponseUtils {

    private ResponseUtils() {

    }

    /**
     * 允许返回
     *
     * @param response
     * @param bean
     * @param allow
     */
    public static void responseJsonAllow(final HttpServletResponse response, Object bean, String... allow) {
        response.setContentType("application/json; charset=utf-8");
        responseJsonData(response, JsonUtil.toJSONStringAllow(bean, allow));
    }

    /**
     * 过虑返回
     *
     * @param response
     * @param bean
     * @param filter
     */
    public static void responseJsonFilter(final HttpServletResponse response, Object bean, String... filter) {
        response.setContentType("application/json; charset=utf-8");
        responseJsonData(response, JsonUtil.toJSONStringFilter(bean, filter));
    }

    /**
     * 直接返回数据
     *
     * @param response
     * @param bean
     */
    public static void responseJson(final HttpServletResponse response, Object bean) {
        response.setContentType("application/json; charset=utf-8");
        responseDate(response, JsonUtil.toJSONString(bean, SerializerFeature.WriteMapNullValue));
    }

    /**
     * 返回json数据
     *
     * @param response
     * @param json
     */
    public static void responseJsonData(final HttpServletResponse response, String json) {
        response.setContentType("application/json; charset=utf-8");
        responseDate(response, json);
    }

    /**
     * 返回html数据
     */
    public static void responseHTML(final HttpServletResponse response, String html) {
        response.setContentType("text/html; charset=utf-8");
        responseDate(response, html);
    }

    private static void responseDate(final HttpServletResponse response, String str) {
        try {
            response.getWriter().println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}