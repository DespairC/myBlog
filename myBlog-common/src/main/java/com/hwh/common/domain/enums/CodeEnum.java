package com.hwh.common.domain.enums;

/**
 * @author HwH
 * @date 2021/9/12 10:08
 * @description 状态码枚举类
 */
public enum CodeEnum {
    // 2xx
    SUCCESS(200, "OK(请求成功)"),

    // 4xx
    BAD_REQUEST(400, "BAD REQUEST(错误请求)"),
    FORBIDDEN(403, "FORBIDDEN(禁止访问)"),
    NOT_FOUND(404, "NOT FOUND(资源未找到)"),
    METHOD_NOT_ALLOWED(405,"METHOD NOT ALLOWED"),
    UNKNOWN_ERROR(406, "发生未知错误");

    /**
     * 状态码
     * */
    private int code;

    /**
     * 响应信息
     * */
    private String msg;

    CodeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    CodeEnum(int code){this.code = code;}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
