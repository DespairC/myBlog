package com.hwh.api.controller;

import com.hwh.api.service.ArticleService;
import com.hwh.common.cache.Cache;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.vo.param.ArticleParam;
import com.hwh.common.domain.vo.param.PageParam;
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
    @PostMapping("")
    public Result articles(@RequestBody PageParam pageParam){
        return Result.success(true, CodeEnum.SUCCESS, articleService.getArticle(pageParam));
    }


    /**
     * 获取热门文章
     * @return 热门文章的集合
     * */
    @PostMapping("/hot")
    @Cache
    public Result hot(){
        int size = 3;
        return Result.success(true, CodeEnum.SUCCESS, articleService.getHotArticle(size));
    }

    /**
     * 获取最新文章
     * @return 最新文章的集合
     * */
    @PostMapping("/new")
    public Result getNew(){
        int size = 5;
        return Result.success(true, CodeEnum.SUCCESS, articleService.getNewArticle(size));
    }

    /**
     * 首页 文章归档
     * @return 档案
     * */
    @PostMapping("/listArchives")
    public Result listArchives(){
        return Result.success(true, CodeEnum.SUCCESS, articleService.getListArchives());
    }

    /**
     * 查询文章
     * @param id 文章id
     * @return 文章具体信息
     * */
    @PostMapping("/view/{id}")
    public Result findArticleById(@PathVariable("id") Long id){
        return Result.success(true, CodeEnum.SUCCESS, articleService.findArticleById(id));
    }

    /**
     * 发布文章
     * @param articleParam 文章参数
     * @return 文章id
     * */
    @PostMapping("/publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return Result.success(true, CodeEnum.SUCCESS, articleService.publishArticle(articleParam));
    }
}
