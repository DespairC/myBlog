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

    @GetMapping
    public Result findAll(){
        return Result.success(true, CodeEnum.SUCCESS, tagService.findAll());
    }

    @GetMapping("/hot")
    public Result getHot(){
        int size = 6;
        return Result.success(true, CodeEnum.SUCCESS, tagService.getHotTag(size));
    }
}
