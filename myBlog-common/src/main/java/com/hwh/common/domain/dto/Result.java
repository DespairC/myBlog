package com.hwh.common.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author HwH
 * @date 2021/9/12 9:57
 * @description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    private Integer code;
    private String msg;
    private Object data;

    public static Result success(Object data){
        return new Result();
    }
}
