package com.hwh.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/17 20:38
 * @description 权限类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    private Long id;
    private String name;
    private String path;
    private String description;
}
