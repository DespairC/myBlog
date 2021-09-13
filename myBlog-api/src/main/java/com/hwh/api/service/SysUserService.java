package com.hwh.api.service;

import com.hwh.common.domain.dto.SysUser;
import com.hwh.common.util.Result;

/**
 * @author HwH
 * @date 2021/9/12 23:25
 * @description 用户服务
 */
public interface SysUserService {
    /**
     * 根据用户id获取用户信息
     * @param id 用户id
     * @return 用户列表
     */
    SysUser getUserById(Long id);

    /**
     * 根据 token 获得用户信息
     * @param token token
     * @return 用户信息
     * */
    Result getUserByToken(String token);

}
