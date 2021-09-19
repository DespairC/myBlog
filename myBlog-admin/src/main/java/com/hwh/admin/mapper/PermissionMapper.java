package com.hwh.admin.mapper;

import com.hwh.common.domain.dto.Permission;
import com.hwh.common.domain.vo.param.AdminPageParam;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/18 10:22
 * @description 权限mapper
 */

@Repository
public interface PermissionMapper {
    /**
     * 获取权限列表
     * @param adminPageParam 页面类
     * @return 权限列表
     * */
    List<Permission> permissionList(AdminPageParam adminPageParam);

    /**
     * 通过id查询权限
     * @param id 权限id
     * @return 权限信息
     * */
    Permission findPermissionById(@Param("id") Long id);

    /**
     * 新增权限
     * @param permission 权限类
     * @return 返回1则成功
     * */
    Integer add(Permission permission);

    /**
     * 更新权限信息
     * @param permission 权限类
     * @return 返回1则成功
     * */
    Integer update(Permission permission);

    /**
     * 删除权限
     * @param id 权限id
     * @return 返回1则成功
     * */
    Integer delete(@Param("id") Long id);
}
