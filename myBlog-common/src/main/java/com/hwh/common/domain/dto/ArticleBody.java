package com.hwh.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/12 21:06
 * @description 文章内容
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleBody {
    private Long id;
    private String content;
    private String contentHtml;
    private Long articleId;
}
