package com.hwh.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.hwh.api.mapper.SysUserMapper;
import com.hwh.api.service.LoginService;
import com.hwh.common.domain.dto.SysUser;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.vo.LoginParam;
import com.hwh.common.util.JWTUtils;
import com.hwh.common.util.RedisUtils;
import com.hwh.common.util.Result;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author HwH
 * @date 2021/9/13 20:59
 * @description
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final SysUserMapper sysUserMapper;
    private final RedisUtils redisUtils;

    @Autowired
    public LoginServiceImpl(SysUserMapper sysUserMapper, RedisUtils redisUtils) {
        this.sysUserMapper = sysUserMapper;
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
        SysUser sysUser =  sysUserMapper.getPasswordByAccount(account, pwd);
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

    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("123456" + SALT));
    }
}
