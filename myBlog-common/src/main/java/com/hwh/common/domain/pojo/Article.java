package com.hwh.common.domain.pojo;

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
    private int commentCounts;
    private Long createDate;
    private String summary;
    private String title;
    private int viewCounts;
    private int weight;
    private Long authorId;
    private Long bodyId;
    private int categoryId;

}
