package com.hwh.admin.controller;

import com.hwh.admin.service.PermissionService;
import com.hwh.common.domain.dto.Permission;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.vo.param.AdminPageParam;
import com.hwh.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HwH
 * @date 2021/9/17 20:24
 * @description
 */
@RestController
@RequestMapping("/admin/permission")
public class AdminController {
    @Autowired
    private PermissionService permissionService;


    /**
     * 获取权限列表
     * @param adminPageParam 页面类
     * */
    @PostMapping("/permissionList")
    public Result permissionList(@RequestBody AdminPageParam adminPageParam){
        return Result.success(true, CodeEnum.SUCCESS, permissionService.permissionList(adminPageParam));
    }

    /**
     * 新增权限
     * @param permission 权限类
     * */
    @PostMapping("/add")
    public Result add(@RequestBody Permission permission){
        return Result.success(true, CodeEnum.SUCCESS, permissionService.add(permission));
    }

    /**
     * 更新权限信息
     * @param permission 权限类
     * */
    @PostMapping("/update")
    public Result update(@RequestBody Permission permission){
        return Result.success(true, CodeEnum.SUCCESS, permissionService.update(permission));
    }

    /**
     * 删除权限
     * @param id 权限id
     * */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        return Result.success(true, CodeEnum.SUCCESS, permissionService.delete(id));
    }


}
