package com.hwh.framework.handler;

import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HwH
 * @date 2021/9/13 10:02
 * @description 对加了@Controller注解的方法进行拦截处理
 */
@ControllerAdvice
public class AllExceptionHandler {
    /**
     * 进行异常处理， 处理Exception.class 的异常
     * */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception exception){
        exception.printStackTrace();
        return Result.error(CodeEnum.SYSTEM_ERROR);
    }
}
