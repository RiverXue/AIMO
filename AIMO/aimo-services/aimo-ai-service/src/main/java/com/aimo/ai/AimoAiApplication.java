package com.aimo.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.aimo")
public class AimoAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AimoAiApplication.class, args);
    }

}