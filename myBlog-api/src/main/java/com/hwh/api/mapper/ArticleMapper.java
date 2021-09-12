package com.hwh.api.mapper;

import com.hwh.common.domain.pojo.Article;
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
     * */
    List<Article> getArticle();

    /**
     * 查询文章
     * */
    List<Article> queryArticle();
}
