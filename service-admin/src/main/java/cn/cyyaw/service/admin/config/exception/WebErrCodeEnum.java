package cn.cyyaw.service.admin.config.exception;

/**
 * 页面错误码枚举
 */
public enum WebErrCodeEnum {
    WEB_SUCCESS(2000, "成功"),
    WEB_LOGINERR(6000, "登录失败"),
    DATA_ERR(7000, "数据库错误"),
    DATA_ERR_MANY(7001, "数据库错误,可能存在多条相同的数据"),
    DATA_ERR_RELATION(7002, "数据库错误,请检SQL语句，或子表是否有数据");
    private Integer code;
    private String msg;

    WebErrCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
