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
    UNKNOWN_ERROR(406, "发生未知错误"),

    // 5xx
    INTERNAL_SERVER_ERROR(500,"Internal Server Error（服务器出错）"),

    // 9xx
    SYSTEM_ERROR(999, "系统异常"),

    // 参数错误
    NULL_PARAM(10001,"参数不能为空"),
    PARAM_PATTERN_INVALID(10002,"参数格式错误"),
    PARAM_NOT_IDEAL(10003,"未查找到信息"),
    FILE_NOT_SUPPORT(10004,"文件格式错误"),
    FILE_UPLOAD_FAIL(10005,"文件上传失败"),
    CANT_NOT_CONVERT_PARAM(10006,"类型转化失败"),

    //登录异常
    LOGIN_VERIFY_CODE_NOT_CORRECT(10007,"验证码错误"),
    ACCOUNT_PWD_NULL_EXISTS(10008,"账户不存在或密码错误"),
    NO_LOGIN(10009,"未登录"),
    SESSION_TIME_OUT(10010,"会话超时"),
    NO_PERMISSION(100011,"无访问权限");


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
