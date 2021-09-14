package com.hwh.api.service;

import com.hwh.common.domain.vo.LoginParam;
import com.hwh.common.util.Result;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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

    /**
     * 注册接口
     * @param loginParam 账号和密码
     * @return 注册结果
     * */
    Result register(@RequestBody LoginParam loginParam);


}
