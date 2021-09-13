package com.hwh.common.exception;

import com.hwh.common.domain.enums.CodeEnum;

/**
 * @author HwH
 * @date 2021/9/12 23:34
 * @description 自定义异常类
 */
public class ErrorException extends RuntimeException{
    private static final long serialVersionUID = -7864604160297181941L;

    private final int code;

    public ErrorException(final int code, final String msg) {
        super(msg);
        this.code = code;
    }

    public ErrorException(final CodeEnum exceptionCode){
        super(exceptionCode.getMsg());
        this.code = exceptionCode.getCode();
    }

    public int getCode(){
        return code;
    }
}
