package com.hwh.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/12 9:37
 * @description 文章
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Long id;
    private Integer commentCounts;
    private Long createDate;
    private String summary;
    private String title;
    private Integer viewCounts;
    private Integer weight;
    private Long authorId;
    private Long bodyId;
    private Long categoryId;

}
