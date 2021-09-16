package com.hwh.api.mapper;

import com.hwh.common.domain.dto.SysUser;
import com.hwh.common.domain.vo.SysUserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author HwH
 * @date 2021/9/12 14:39
 * @description 用户mapper
 */
@Repository
public interface SysUserMapper {
    /**
     * 根据用户id获取用户信息
     * @param id 用户id
     * @return 用户列表
     */
    SysUser getUserById(@Param("id") Long id);

    /**
     * 根据账号密码获取用户
     * @param account 账号
     * @param password 密码
     * @return 用户
     * */
    SysUser getPasswordByAccount(@Param("account") String account, @Param("password") String password);

    /**
     * 根据账号获取用户
     * @param account 账号
     * @return 用户
     * */
    SysUser getUserByAccount(@Param("account") String account);

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
    SysUserVo findUserById(@Param("id") Long id);
}
