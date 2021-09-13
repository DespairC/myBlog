package com.hwh.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/12 9:52
 * @description 文章标签关系
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    private Long id;
    private String avatar;
    private String tagName;
}
