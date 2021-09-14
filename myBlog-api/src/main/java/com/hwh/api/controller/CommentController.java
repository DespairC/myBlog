package com.hwh.api.controller;

import com.hwh.api.service.CommentService;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.util.Result;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("article/{id}")
    public Result getCommentByArticleId(@PathVariable("id") Long id){
        return Result.success(true, CodeEnum.SUCCESS, commentService.getCommentByArticleId(id));
    }

}
