package com.hwh.common.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/13 15:12
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Archives {
    private Integer year;
    private Integer month;
    private Integer count;
}