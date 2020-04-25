package cn.cyyaw.common.util;

import javax.servlet.http.HttpServletRequest;

public class HttpInfoUtil {


    /**
     * 判断是否为ajax请求
     *
     * @param request
     * @return
     */
    private boolean isAjax(HttpServletRequest request) {
        if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 判断是否是GET
     */






























}
