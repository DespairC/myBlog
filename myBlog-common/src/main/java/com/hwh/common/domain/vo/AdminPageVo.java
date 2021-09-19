package com.hwh.common.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/19 10:59
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminPageVo<T> {
    private List<T> list;
    private Long total;
}
