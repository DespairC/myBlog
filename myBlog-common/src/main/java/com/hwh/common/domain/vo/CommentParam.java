package com.hwh.common.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/15 17:37
 * @description 前端发送评论类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentParam {
    private Long articleId;

    private String content;

    private Long parent;

    private Long toUserId;
}
