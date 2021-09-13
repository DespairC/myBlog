package com.hwh.api.mapper;

import com.hwh.common.domain.dto.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
