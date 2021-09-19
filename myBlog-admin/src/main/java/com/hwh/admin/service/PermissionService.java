package com.hwh.admin.service;

import com.hwh.common.domain.dto.Permission;
import com.hwh.common.domain.vo.AdminPageVo;
import com.hwh.common.domain.vo.param.AdminPageParam;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/17 20:27
 * @description
 */
public interface PermissionService {
    /**
     * 获取权限列表
     * @param adminPageParam 页面类
     * @return 权限列表
     * */
    AdminPageVo<Permission> permissionList(AdminPageParam adminPageParam);

    /**
     * 新增权限
     * @param permission 权限类
     * */
    Integer add(Permission permission);

    /**
     * 更新权限信息
     * @param permission 权限类
     * */
    Integer update(Permission permission);

    /**
     * 删除权限
     * @param id 权限id
     * */
    Integer delete(Long id);

}
