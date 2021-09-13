package com.hwh.api.mapper;

import com.hwh.common.domain.dto.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author HwH
 * @date 2021/9/12 10:20
 * @description 文章mapper
 */
@Repository
public interface ArticleMapper {

    /**
     * 获取文章
     * @param page 目录页面
     * @param pageSize 页文章数
     * @return 文章的集合
     * */
    List<Article> getArticle(@Param("page") int page, @Param("pageSize") int pageSize);

    /**
     * 查询文章
     * @param id 文章id
     * @return 查询的文章
     * */
    Article getArticleById(@Param("id") int id);
}
