package com.hwh.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.hwh.api.service.LoginService;
import com.hwh.api.service.SysUserService;
import com.hwh.common.domain.dto.SysUser;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.vo.param.LoginParam;
import com.hwh.common.util.JWTUtils;
import com.hwh.common.util.RedisUtils;
import com.hwh.common.util.Result;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author HwH
 * @date 2021/9/13 20:59
 * @description
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

    private final SysUserService sysUserService;
    private final RedisUtils redisUtils;

    @Autowired
    public LoginServiceImpl(SysUserService sysUserService, RedisUtils redisUtils) {
        this.sysUserService = sysUserService;
        this.redisUtils = redisUtils;
    }

    private static final String SALT = "myblog@!#";

    @Override
    public Result login(LoginParam loginParam) {
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            return Result.error(CodeEnum.NULL_PARAM);
        }
        String pwd = DigestUtils.md5Hex(password + SALT);
        SysUser sysUser =  sysUserService.getPasswordByAccount(account, pwd);
        if(sysUser == null){
            return Result.error(CodeEnum.ACCOUNT_PWD_NULL_EXISTS);
        }

        String token = JWTUtils.createToken(sysUser.getId());
        //保存到redis
        redisUtils.set(token, JSON.toJSONString(sysUser), 1, TimeUnit.DAYS);
        return Result.success(true, CodeEnum.SUCCESS, token);
       }

    @Override
    public Result logout(String token) {
        redisUtils.del(token);
        return Result.success(true, CodeEnum.SUCCESS, null);
    }

    @Override
    public Result register(LoginParam loginParam) {
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        String nickname = loginParam.getNickname();
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)
                || StringUtils.isBlank(nickname)){
            return Result.error(CodeEnum.NULL_PARAM);
        }
        if(sysUserService.getUserByAccount(account) != null){
            return Result.error(CodeEnum.ACCOUNT_EXIST);
        }
        SysUser sysUser = new SysUser();
        sysUser.setAccount(account);
        //密码加密
        sysUser.setPassword(DigestUtils.md5Hex(password + SALT));
        sysUser.setNickname(loginParam.getNickname());
        sysUser.setCreateDate(System.currentTimeMillis());
        sysUser.setLastLogin(System.currentTimeMillis());
        //默认头像
        sysUser.setAvatar("/static/img/logo.b3a48c0.png");
        sysUser.setAdmin(0);
        sysUser.setDeleted(0);
        sysUser.setSalt("");
        sysUser.setStatus("");
        sysUser.setEmail("");

        //新增用户
        sysUserService.addUser(sysUser);
        sysUser.setId(sysUser.getId());

        //登录token
        String token = JWTUtils.createToken(sysUser.getId());
        redisUtils.set(token, JSON.toJSONString(sysUser), 1, TimeUnit.DAYS);
        return Result.success(true, CodeEnum.SUCCESS, token);
    }
}
