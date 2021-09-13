package com.hwh.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HwH
 * @date 2021/9/12 9:05
 * @description 测试接口
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "Hello, HwH!";
    }
}
