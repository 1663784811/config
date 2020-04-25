package cn.cyyaw.common.util;

import java.util.UUID;

/**
 * 字符串工具类
 */
public class StringUtilWHY {
    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUUID() {
        String str = UUID.randomUUID().toString();
        return str.replace("-", "");
    }

}
