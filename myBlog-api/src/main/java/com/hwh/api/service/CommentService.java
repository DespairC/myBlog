package com.hwh.api.service;


import com.hwh.common.domain.vo.param.CommentParam;
import com.hwh.common.domain.vo.CommentVo;
import com.hwh.common.util.Result;

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

    /**
     * 新增评论
     * @param commentParam 评论参数类
     * */
    Result comment(CommentParam commentParam);
}
