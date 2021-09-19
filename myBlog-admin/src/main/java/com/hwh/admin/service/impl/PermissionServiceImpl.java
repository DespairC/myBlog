package com.hwh.admin.service.impl;

import com.hwh.admin.mapper.PermissionMapper;
import com.hwh.admin.service.PermissionService;
import com.hwh.common.domain.dto.Permission;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.vo.AdminPageVo;
import com.hwh.common.domain.vo.param.AdminPageParam;
import com.hwh.common.exception.ErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author HwH
 * @date 2021/9/17 20:27
 * @description
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public AdminPageVo<Permission> permissionList(AdminPageParam adminPageParam) {
        if(adminPageParam == null){
            throw new ErrorException(CodeEnum.NULL_PARAM);
        }
        //计算当前页面位置
        adminPageParam.setCurrentPage((adminPageParam.getCurrentPage() - 1) * adminPageParam.getPageSize());
        List<Permission> list = permissionMapper.permissionList(adminPageParam);
        return new AdminPageVo<>(list, Integer.toUnsignedLong(list.size()));
    }

    @Override
    public Integer add(Permission permission) {
        if(permission == null){
            throw new ErrorException(CodeEnum.NULL_PARAM);
        }
        return permissionMapper.add(permission);
    }

    @Override
    public Integer update(Permission permission) {
        if(permission == null){
            throw new ErrorException(CodeEnum.NULL_PARAM);
        }
        return permissionMapper.update(permission);
    }

    @Override
    public Integer delete(Long id) {
        return permissionMapper.delete(id);
    }
}
