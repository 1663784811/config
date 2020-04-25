package cn.cyyaw.common.util;

public class WhyException extends RuntimeException {

    String message;
    Integer code;

    public WhyException() {
    }

    public WhyException(String message) {
        this.message = message;
    }

    public WhyException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }


    @Override
    public String getMessage() {
        String m = super.getMessage();
        if (null != message) {
            m = message;
        }
        return message;
    }
}
