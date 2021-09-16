package com.hwh.api.controller;

import com.hwh.api.service.TagService;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HwH
 * @date 2021/9/13 8:56
 * @description
 */
@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 获得所有标签
     * @return 所有标签集合
     * */
    @GetMapping
    public Result findAll(){
        return Result.success(true, CodeEnum.SUCCESS, tagService.findAll());
    }

    /**
     * 寻找热门标签（默认前6）
     * @return 热门标签集合
     * */
    @GetMapping("/hot")
    public Result getHot(){
        int size = 6;
        return Result.success(true, CodeEnum.SUCCESS, tagService.getHotTag(size));
    }

    /**
     * 获得所有标签细节
     * @return 所有标签集合细节
     * */
    @GetMapping("/detail")
    public Result detail(){
        return Result.success(true, CodeEnum.SUCCESS, tagService.findAllDetail());
    }


}
