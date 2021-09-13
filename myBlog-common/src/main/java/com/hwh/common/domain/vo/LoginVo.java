package com.hwh.common.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HwH
 * @date 2021/9/13 23:33
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginVo {
    private Long id;

    private String account;

    private String nickname;

    private String avatar;
}
