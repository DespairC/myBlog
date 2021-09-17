package com.hwh.common.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/14 23:37
 * @description 评论展示类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVo {
    private Long id;
    private String content;
    private String createDate;
    private SysUserVo author;
    private List<CommentVo> childrens;
    private SysUserVo toUser;
    private Integer level;
}
