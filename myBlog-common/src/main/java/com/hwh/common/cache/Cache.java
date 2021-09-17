package com.hwh.common.cache;

import java.lang.annotation.*;

/**
 * @author HwH
 * @date 2021/9/17 9:06
 * @description
 */
//修饰对象，方法
@Target({ElementType.METHOD})
//运行时有效
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    long expire() default 1 * 60 * 1000;

    String name() default "";

}