package com.hwh.api.mapper;

import com.hwh.common.domain.dto.ArticleBody;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author HwH
 * @date 2021/9/16 12:35
 * @description
 */
@Repository
public interface ArticleBodyMapper {
    /**
     * 获取文章主体内容
     * @param articleId 文章id
     * @return 文章主体内容
     * */
    ArticleBody getArticleBodyById(@Param("articleId") Long articleId);

    /**
     * 插入文章主体内容
     * @param articleBody 文章内容
     * @return 返回1即成功
     * */
    Integer insert(ArticleBody articleBody);
}
