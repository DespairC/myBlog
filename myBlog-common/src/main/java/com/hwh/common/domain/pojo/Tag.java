package com.hwh.common.domain.pojo;

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
    private Long articleId;
    private Long tagId;
}
