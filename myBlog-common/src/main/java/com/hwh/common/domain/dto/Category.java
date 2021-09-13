package com.hwh.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/12 21:22
 * @description 文章类别
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Long id;
    private String avatar;
    private String categoryName;
    private String description;
}
