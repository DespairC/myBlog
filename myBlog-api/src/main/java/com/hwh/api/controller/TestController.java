package com.hwh.api.controller;

import com.hwh.api.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HwH
 * @date 2021/9/12 9:05
 * @description 测试接口
 */
@RestController
public class TestController {
    @Autowired
    private ArticleMapper articleMapper;

    @PostMapping("/test")
    public String test(){
        return articleMapper.getArticle(0,5).toString();
    }
}
