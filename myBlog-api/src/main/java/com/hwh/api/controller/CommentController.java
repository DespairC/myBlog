package com.hwh.api.controller;

import com.hwh.api.service.CommentService;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.vo.param.CommentParam;
import com.hwh.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HwH
 * @date 2021/9/14 23:30
 * @description 评论功能接口
 */

@RestController
@RequestMapping("/comment/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 查询评论
     * @param id 文章id
     * @return 评论集合
     * */
    @GetMapping("article/{id}")
    public Result getCommentByArticleId(@PathVariable("id") Long id){
        return Result.success(true, CodeEnum.SUCCESS, commentService.getCommentByArticleId(id));
    }

    /**
     * 新增评论
     * @param commentParam 评论参数类
     * */
    @PostMapping("create/change")
    public Result comment(@RequestBody CommentParam commentParam){
        return commentService.comment(commentParam);
    }

}
