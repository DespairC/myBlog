package com.hwh.common.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/14 23:39
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserVo {
    private Long id;
    private String nickname;
    private String avatar;
}
