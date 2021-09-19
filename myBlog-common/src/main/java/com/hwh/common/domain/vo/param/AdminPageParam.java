package com.hwh.common.domain.vo.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/17 20:36
 * @description 页面类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminPageParam {
    private Integer currentPage;

    private Integer pageSize;

    private String queryString;
}
