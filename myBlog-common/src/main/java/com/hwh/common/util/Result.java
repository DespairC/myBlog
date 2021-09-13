package com.hwh.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hwh.common.domain.enums.CodeEnum;
import lombok.Data;
import lombok.ToString;

/**
 * @author HwH
 * @date 2021/9/12 9:57
 * @description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ToString
public class Result<T> {

    private Boolean success;
    private Integer code;
    private String msg;
    private Object data;

    /**
     * 成功响应（有数据）
     * @param codeEnum 响应码
     * @param data 数据
     */
    public static <T> Result<T> success (CodeEnum codeEnum, T data){
        return new Result<T>(codeEnum, data);
    }

    public static <T> Result<T> success (Boolean success, CodeEnum codeEnum, T data){
        return new Result<T>(success, codeEnum, data);
    }

    public static <T> Result<T> success (Integer code, String msg, T data){
        return new Result<T>(code, msg, data);
    }

    /**
     * 成功响应（无数据）
     * @param codeEnum 响应码
     * @param <T>
     * @return
     */
    public static <T> Result<T> success (CodeEnum codeEnum){
        return new Result<T>(codeEnum);
    }

    /**
     * 错误响应
     * @param codeEnum 响应码
     * @param <T>
     * @return
     */
    public static <T> Result<T> error (CodeEnum codeEnum){
        return new Result<>(codeEnum);
    }

    public static <T> Result<T> error (CodeEnum codeEnum, T data){
        return new Result<>(codeEnum, data);
    }

    public static <T> Result<T> error (Integer code, String msg){
        return new Result<>(code,msg);
    }

    public Result (CodeEnum codeEnum){
        this.code = codeEnum.getCode();
        this.msg =codeEnum.getMsg();
    }

    public Result (CodeEnum codeEnum, T data){
        this(codeEnum);
        this.data = data;
    }

    public Result (Boolean success, CodeEnum codeEnum, T data){
        this(codeEnum);
        this.success = success;
        this.data = data;
    }

    public Result (Integer code, String msg){
        this.code = code;
        this.msg =msg;
    }

    public Result (Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result (){ }

}
