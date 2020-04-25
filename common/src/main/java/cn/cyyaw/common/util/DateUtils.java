package cn.cyyaw.common.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {


    /**
     * 常用的日期格式化代码.
     */
    public static final String[] PATTERN_CHANG_YONG = new String[]{"yyyy-MM", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss", "yyyy/MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy:MM:dd HH:mm:ss"};

    /**
     * 隐藏实例化
     */
    private DateUtils() {

    }

    /**
     * 根据字符串获取“常用格式化字符串数组”对应的日期.
     *
     * @param str 待转换字符串
     * @return the date
     */
    public static Date getDate(final String str) {
        return getDate(str, PATTERN_CHANG_YONG);
    }

    /**
     * 根据字符串获取“格式化字符串数组”对应的日期.
     *
     * @param str           待转换字符串
     * @param parsepatterns 日期格式化代码
     * @return the date
     */
    public static Date getDate(final String str, final String... parsepatterns) {
        if (str == null || parsepatterns == null) {
            return null;
        }

        SimpleDateFormat parser = null;
        ParsePosition pos = new ParsePosition(0);
        for (int i = 0; i < parsepatterns.length; i++) {
            if (i == 0) {
                parser = new SimpleDateFormat(parsepatterns[0]);
            } else {
                parser.applyPattern(parsepatterns[i]);
            }
            pos.setIndex(0);
            Date date = parser.parse(str, pos);
            if (date != null && pos.getIndex() == str.length()) {
                return date;
            }
        }
        return null;
    }


    /**
     * 将long转换成对应的日期文本.
     *
     * @param longShuRu the longShuRu
     * @return the long time
     */
    public static String getStringDate(final Long longShuRu) {
        Integer hour = 0;
        Integer minute = 0;
        Integer second = 0;
        second = longShuRu.intValue() / 1000;

        if (second > 60) {
            minute = second / 60;
            second = second % 60;
        }
        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        return (StringUtils.leftPad(hour.toString(), 2, "0") + ":" + StringUtils.leftPad(minute.toString(), 2, "0") + ":" + StringUtils.leftPad(second.toString(), 2, "0"));
    }


    /**
     * 根据日期获取“yyyy:MM:dd HH:mm:ss”对应的字符串.
     *
     * @param dateshuru 待转换日期对象
     * @return the date
     */
    public static String getStringDate(final Date dateshuru) {
        return getStringDate(dateshuru, "yyyy:MM:dd HH:mm:ss");
    }

    /**
     * 根据日期和格式返回文本
     *
     * @param dateshuru 待转换日期对象
     * @param strgeshi  转换的格式
     * @return the wen be
     */
    public static String getStringDate(final Date dateshuru, final String strgeshi) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(strgeshi);
        return dateFormat.format(dateshuru);
    }

}
