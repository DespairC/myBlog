package com.hwh.api.controller;

import com.hwh.api.service.CategoryService;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HwH
 * @date 2021/9/15 21:30
 * @description
 */
@RestController
@RequestMapping("/categorys")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * 获取所有类别
     * @return 所有类别（不包括细节）
     * */
    @GetMapping
    public Result listCategory(){
        return Result.success(true, CodeEnum.SUCCESS, categoryService.findAll());
    }

    /**
     * 获取所有类别细节
     *
     * */
    @GetMapping("/detail")
    public Result findAllDetail(){
        return Result.success(true, CodeEnum.SUCCESS, categoryService.findAllDetail());
    }
}
