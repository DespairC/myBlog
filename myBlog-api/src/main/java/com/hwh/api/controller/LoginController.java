package com.hwh.api.controller;

import com.hwh.api.service.LoginService;
import com.hwh.common.domain.vo.LoginParam;
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

    @PostMapping("/login")
    public Result login(@RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }

    @GetMapping("/logout")
    public Result logout(@RequestHeader("Authorization") String token){
        return loginService.logout(token);
    }
}
