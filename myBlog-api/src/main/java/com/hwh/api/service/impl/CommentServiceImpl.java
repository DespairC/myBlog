package com.hwh.api.service.impl;

import com.hwh.api.mapper.CommentMapper;
import com.hwh.api.service.CommentService;
import com.hwh.api.service.SysUserService;
import com.hwh.common.domain.dto.Comment;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.vo.param.CommentParam;
import com.hwh.common.domain.vo.CommentVo;
import com.hwh.common.domain.vo.SysUserVo;
import com.hwh.common.util.Result;
import com.hwh.common.util.TimeUtil;
import com.hwh.common.util.UserThreadLocal;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HwH
 * @date 2021/9/14 23:33
 * @description 评论服务实现类
 */

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    private final SysUserService sysUserService;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper, SysUserService sysUserService) {
        this.commentMapper = commentMapper;
        this.sysUserService = sysUserService;
    }

    private CommentVo copy(Comment comment){
        if(comment == null){
            return null;
        }
        CommentVo commentVo = new CommentVo();
        BeanUtils.copyProperties(comment, commentVo);
        //创建时间
        commentVo.setCreateDate(TimeUtil.longToDate(comment.getCreateDate()));
        //作者信息
        SysUserVo sysUserVo = sysUserService.findUserById(comment.getAuthorId());
        commentVo.setAuthor(sysUserVo);
        //子评论集合
        commentVo.setChildrens(findChildren(comment.getId()));
        //评论对象
        if(comment.getLevel() > 1){
            commentVo.setToUser(sysUserService.findUserById(comment.getToUid()));
        }
        return commentVo;
    }

    private List<CommentVo> findChildren(Long id){
        return copyList(commentMapper.getCommentById(id));
    }

    private List<CommentVo> copyList(List<Comment> commentList){
        List<CommentVo> list = new ArrayList<>();
        for (Comment comment:commentList) {
            list.add(copy(comment));
        }
        return list;
    }

    @Override
    public List<CommentVo> getCommentByArticleId(Long articleId) {
        return copyList(commentMapper.getCommentByArticleId(articleId));
    }

    @Override
    public Result comment(CommentParam commentParam) {
        Comment comment = new Comment();
        comment.setArticleId(commentParam.getArticleId());
        comment.setContent(commentParam.getContent());
        comment.setAuthorId(UserThreadLocal.get().getId());
        Long parent = commentParam.getParent();
        comment.setParentId(parent == null? 0 : parent);
        if(parent == null || parent == 0){
            comment.setLevel(1);
        }else {
            comment.setLevel(2);
        }
        Long toUserId = commentParam.getToUserId();
        comment.setToUid(toUserId == null? 0 : toUserId);
        comment.setCreateDate(System.currentTimeMillis());
        commentMapper.addComment(comment);
        return Result.success(true, CodeEnum.SUCCESS , null);
    }
}
