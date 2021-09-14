package com.hwh.api.service;


import com.hwh.common.domain.vo.CommentVo;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/14 23:33
 * @description 评论服务
 */
public interface CommentService {

    /**
     * 获取文章评论
     * @param articleId 文章ID
     * @return 评论集合
     * */
    List<CommentVo> getCommentByArticleId(Long articleId);
}
