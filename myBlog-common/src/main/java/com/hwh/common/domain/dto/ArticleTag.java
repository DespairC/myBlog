package com.hwh.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/16 12:55
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTag {
    private Long id;
    private Long articleId;
    private Long tagId;
}
