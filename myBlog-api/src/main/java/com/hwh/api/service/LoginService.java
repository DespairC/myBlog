package com.hwh.api.service;

import com.hwh.common.domain.vo.LoginParam;
import com.hwh.common.util.Result;

/**
 * @author HwH
 * @date 2021/9/13 15:40
 * @description
 */
public interface LoginService {
    /**
     * 登录
     * @param loginParam 登录信息
     * @return token
     */
    Result login(LoginParam loginParam);

    /**
     * 注销
     * @param token token
     * @return 结果
     * */
    Result logout(String token);


}
