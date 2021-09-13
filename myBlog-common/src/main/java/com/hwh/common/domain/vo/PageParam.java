package com.hwh.common.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author HwH
 * @date 2021/9/13 0:28
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageParam {
    private int page;
    private int pageSize;
}
