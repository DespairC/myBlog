package com.hwh.api.service;

import com.hwh.common.domain.dto.SysUser;
import com.hwh.common.domain.vo.SysUserVo;
import com.hwh.common.util.Result;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 检查token是否存在
     * @param token token
     * @return 用户信息
     * */
    SysUser checkToken(String token);

    /**
     * 根据账号密码获取用户
     * @param account 账号
     * @param password 密码
     * @return 用户
     * */
    SysUser getPasswordByAccount(String account, String password);

    /**
         * 根据账号获取用户
         * @param account 账号
         * @return 用户
         * */
    SysUser getUserByAccount(String account);

    /**
     * 新增用户
     * @param sysUser 用户信息
     * @return 主键id
     * */
    Long addUser(SysUser sysUser);

    /**
     * 获取基本用户信息
     * @param id 用户id
     * @return 用户基本信息
     * */
    SysUserVo findUserById(Long id);

}
