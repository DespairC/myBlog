package com.hwh.api.mapper;

import com.hwh.common.domain.dto.ArticleTag;
import org.springframework.stereotype.Repository;

/**
 * @author HwH
 * @date 2021/9/16 12:54
 * @description 文章与标签关系mapper
 */
@Repository
public interface ArticleTagMapper {
    /**
     * 插入新的关系
     * @param articleTag 新的关系
     * @return 返回1为成功
     * */
    Integer insert(ArticleTag articleTag);
}
