package com.hwh.api.controller;

import com.hwh.api.service.ArticleService;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.vo.PageParam;
import com.hwh.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HwH
 * @date 2021/9/12 9:19
 * @description 文章接口
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 获取文章列表
     * @param pageParam 文章数和起始页码
     * @return 返回文章列表
     * */
    @PostMapping("/")
    public Result articles(@RequestBody PageParam pageParam){
        return Result.success(true, CodeEnum.SUCCESS, articleService.getArticle(pageParam));
    }


    /**
     * 获取热门文章
     * @return 热门文章的集合
     * */
    @GetMapping("/hot")
    public Result hot(){
        int size = 3;
        return Result.success(true, CodeEnum.SUCCESS, articleService.getHotArticle(size));
    }

    @GetMapping("/new")
    public Result getNew(){
        int size = 5;
        return Result.success(true, CodeEnum.SUCCESS, articleService.getNewArticle(size));
    }



}
