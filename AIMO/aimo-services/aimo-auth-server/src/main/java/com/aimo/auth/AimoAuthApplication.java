package com.aimo.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.aimo") // 根据实际情况调整扫描路径
public class AimoAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AimoAuthApplication.class, args);
    }

}