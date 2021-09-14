package com.hwh.api.service.impl;

import com.hwh.api.mapper.ArticleMapper;
import com.hwh.api.service.ThreadService;
import com.hwh.common.domain.dto.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author HwH
 * @date 2021/9/14 22:58
 * @description
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    @Override
    @Async("takeExecutor")
    public void updateViewCount(ArticleMapper articleMapper, Article article) {
        article.setViewCounts(article.getViewCounts() + 1);
        articleMapper.update(article);
    }
}
