package com.hwh.api.controller;

import com.hwh.api.mapper.SysUserMapper;
import com.hwh.api.service.SysUserService;
import com.hwh.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HwH
 * @date 2021/9/13 8:56
 * @description
 */
@RestController
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token){
        return sysUserService.getUserByToken(token);
    }

}
