package com.hwh.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author HwH
 * @date 2021/9/12 8:48
 * @description 启动类
 */
@SpringBootApplication(scanBasePackages =
        {
                "com.hwh.api",
                "com.hwh.framework",
                "com.hwh.common"

        })
@MapperScan(basePackages = "com.hwh.**.mapper")
@EnableTransactionManagement
@Configuration
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
