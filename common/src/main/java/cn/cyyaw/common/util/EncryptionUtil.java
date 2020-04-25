package cn.cyyaw.common.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 加密
 */
public class EncryptionUtil {

    /**
     * MD5
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }


}
