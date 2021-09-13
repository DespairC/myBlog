package com.hwh.api.service.impl;

import com.hwh.api.mapper.SysUserMapper;
import com.hwh.api.service.SysUserService;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.dto.SysUser;
import com.hwh.common.exception.ErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/12 23:26
 * @description 用户服务实现类
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    private SysUserMapper sysUserMapper;

    @Autowired
    public SysUserServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public SysUser getUserById(Long id) {
        if(id == null){
            throw new ErrorException(CodeEnum.NULL_PARAM);
        }
        return sysUserMapper.getUserById(id);
    }
}
