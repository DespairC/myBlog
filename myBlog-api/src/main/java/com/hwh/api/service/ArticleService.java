package com.hwh.api.service;

import com.hwh.common.domain.vo.Archives;
import com.hwh.common.domain.vo.ArticleVo;
import com.hwh.common.domain.vo.param.ArticleParam;
import com.hwh.common.domain.vo.param.PageParam;
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
    List<ArticleVo> getHotArticle(int size);

    /**
     * 获取热门文章
     * @param size 热门文章数量
     * @return 文章的集合
     * */
    List<ArticleVo> getNewArticle(int size);

    /**
     * 首页 文章归档
     * @return 档案
     * */
    List<Archives> getListArchives();

    /**
     * 查询文章
     * @param id 文章id
     * @return 文章具体信息
     * */
    ArticleVo findArticleById(Long id);

    /**
     * 发布文章
     * @param articleParam 文章参数
     * @return 文章id
     * */
    ArticleVo publishArticle(ArticleParam articleParam);
}
