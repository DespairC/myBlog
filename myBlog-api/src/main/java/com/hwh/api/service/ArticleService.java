package com.hwh.api.service;

import com.hwh.common.domain.dto.Article;
import com.hwh.common.domain.vo.ArticleVo;
import com.hwh.common.domain.vo.PageParam;
import com.hwh.common.util.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/12 9:55
 * @description 文章服务类
 */
public interface ArticleService {

    /**
     * 获取文章
     * @param pageParam 页面信息
     * @return 文章的集合
     * */
    List<ArticleVo> getArticle(@Param("pageParam") PageParam pageParam);

    /**
     * 获取热门文章
     * @param size 热门文章数量
     * @return 文章的集合
     * */
    List<ArticleVo> getHotArticle(int size);}
