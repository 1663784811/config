package cn.cyyaw.common.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 字符串工具类
 */
public class WhyStringUtil {

    private static String string = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";

    public static String getRandomString(int length) {
        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len - 1)));
        }
        return sb.toString();
    }

    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }

    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUUID() {
        String str = UUID.randomUUID().toString();
        return str.replace("-", "");
    }
    /**
     * 生成订单号  2019 07 07 16 16 10
     *
     * @return
     */
    public static String createOrderNum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(new Date());
        for (int i = 0; i < 6; i++) {
            format += getRandom(10);
        }
        return format;
    }
}
