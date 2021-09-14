package com.hwh.api.service;

import com.hwh.api.mapper.ArticleMapper;
import com.hwh.common.domain.dto.Article;

/**
 * @author HwH
 * @date 2021/9/14 22:56
 * @description
 */
public interface ThreadService {
    /**
     * 异步更新阅读数量
     * */
    public void updateViewCount(ArticleMapper articleMapper, Article article);
}
