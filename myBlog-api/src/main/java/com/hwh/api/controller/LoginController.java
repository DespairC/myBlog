package com.hwh.api.controller;

import com.hwh.api.service.LoginService;
import com.hwh.common.domain.vo.param.LoginParam;
import com.hwh.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HwH
 * @date 2021/9/13 15:39
 * @description
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录接口
     * @param loginParam 账号和密码
     * @return token
     * */
    @PostMapping("/login")
    public Result login(@RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }

    /**
     * 注销接口
     * @param token 请求头的授权
     * @return 用户信息
     * */
    @GetMapping("/logout")
    public Result logout(@RequestHeader("Authorization") String token){
        return loginService.logout(token);
    }

    /**
     * 注册接口
     * @param loginParam 账号和密码
     * @return 注册结果
     * */
    @PostMapping("/register")
    public Result register(@RequestBody LoginParam loginParam){
        return loginService.register(loginParam);
    }

}
