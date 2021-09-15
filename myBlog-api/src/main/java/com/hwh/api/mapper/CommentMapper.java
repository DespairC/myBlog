package com.hwh.api.mapper;

import com.hwh.common.domain.dto.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/14 23:33
 * @description 评论mapper
 */
@Repository
public interface CommentMapper {

    /**
     * 获取文章评论
     * @param articleId 文章ID
     * @return 评论集合
     * */
    List<Comment> getCommentByArticleId(@Param("articleId") Long articleId);

    /**
     * 获取子评论
     * @param id 评论Id
     * @return 子评论集合
     * */
    List<Comment> getCommentById(@Param("id") Long id);

    /**
     * 新增评论
     * @param comment 评论类
     * */
    void addComment(@Param("comment") Comment comment);
}
