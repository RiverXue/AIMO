package com.aimo.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.aimo")
public class AimoSocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(AimoSocialApplication.class, args);
    }

}