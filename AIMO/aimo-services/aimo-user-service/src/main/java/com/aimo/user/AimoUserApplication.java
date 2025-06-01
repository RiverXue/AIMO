package com.aimo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.aimo")
@SpringBootApplication(scanBasePackages = {
        "com.aimo.user",
        "com.aimo.auth" // ✅ 扫描 auth 模块中的配置类
})
public class AimoUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AimoUserApplication.class, args);
    }

}