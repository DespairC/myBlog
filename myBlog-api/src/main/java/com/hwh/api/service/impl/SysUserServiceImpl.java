package com.hwh.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.hwh.api.mapper.SysUserMapper;
import com.hwh.api.service.SysUserService;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.dto.SysUser;
import com.hwh.common.domain.vo.LoginVo;
import com.hwh.common.exception.ErrorException;
import com.hwh.common.util.JWTUtils;
import com.hwh.common.util.RedisUtils;
import com.hwh.common.util.Result;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HwH
 * @date 2021/9/12 23:26
 * @description 用户服务实现类
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    private SysUserMapper sysUserMapper;
    private RedisUtils redisUtils;

    @Autowired
    public SysUserServiceImpl(SysUserMapper sysUserMapper, RedisUtils redisUtils) {
        this.sysUserMapper = sysUserMapper;
        this.redisUtils = redisUtils;
    }

    @Override
    public SysUser getUserById(Long id) {
        if(id == null){
            throw new ErrorException(CodeEnum.NULL_PARAM);
        }
        return sysUserMapper.getUserById(id);
    }

    @Override
    public Result getUserByToken(String token) {
        Map<String, Object> map = JWTUtils.checkToken(token);
        if(map == null){
            return Result.error(CodeEnum.NO_LOGIN);
        }
        String userJson = (String) redisUtils.get(token);
        if(ObjectUtils.isEmpty(userJson)){
            return Result.error(CodeEnum.NULL_PARAM);
        }
        SysUser sysUser = JSON.parseObject(userJson, SysUser.class);

        LoginVo loginVo = new LoginVo();
        loginVo.setAccount(sysUser.getAccount());
        loginVo.setId(sysUser.getId());
        loginVo.setNickname(sysUser.getNickname());
        loginVo.setAvatar(sysUser.getAvatar());

        return Result.success(true, CodeEnum.SUCCESS, loginVo);
    }
}
