package com.hwh.framework.handler;

import com.alibaba.fastjson.JSON;
import com.hwh.api.service.SysUserService;
import com.hwh.common.domain.dto.SysUser;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.util.Result;
import com.hwh.common.util.UserThreadLocal;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author HwH
 * @date 2021/9/14 16:02
 * @description 登录拦截器
 */

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        String token  = request.getHeader("Authorization");
        log.info("------------------------------------------------------");
        log.info("开始时间: {}", LocalDateTime.now());
        log.info("请求URL: {}", request.getRequestURL().toString());
        log.info("请求方式: {}" , request.getMethod());
        log.info(" TOKEN: {}", token);
        log.info("------------------------------------------------------");

        if(token == null){
            send(response, Result.error(CodeEnum.NO_LOGIN));
            return false;
        }

        SysUser sysUser = sysUserService.checkToken(token);
        if(sysUser == null){
            send(response, Result.error(CodeEnum.NO_LOGIN));
            return false;
        }

        UserThreadLocal.put(sysUser);

        //放行
        return true;
    }

    private void send(HttpServletResponse response, Result result) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(result));
    }

    /**
     * 在拦截器拦截的接口执行完毕后执行
     * 移除ThreadLocal的储存，防止内存泄漏(因为这里值的储存是强引用)
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.remove();
    }
}
