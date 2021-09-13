package com.hwh.api.service;

import com.hwh.common.domain.dto.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    SysUser getUserById(@Param("id") Long id);
}
