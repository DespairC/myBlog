package com.hwh.common.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/12 21:13
 * @description 用于展示的标签vo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagVo {
    private Long id;
    private String avatar;
    private String tagName;
}
