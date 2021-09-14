package com.hwh.common.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/13 21:02
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam {
    private String account;

    private String password;

    private String nickname;
}
