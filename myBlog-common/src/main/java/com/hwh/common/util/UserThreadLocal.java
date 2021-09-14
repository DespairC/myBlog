package com.hwh.common.util;

import com.hwh.common.domain.dto.SysUser;

/**
 * @author HwH
 * @date 2021/9/14 17:41
 * @description
 */
public class UserThreadLocal{
    private UserThreadLocal(){}

    private static final ThreadLocal<SysUser> LOCAL = new ThreadLocal<>();

    public static void put(SysUser sysUser){
        LOCAL.set(sysUser);
    }

    public static SysUser get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
