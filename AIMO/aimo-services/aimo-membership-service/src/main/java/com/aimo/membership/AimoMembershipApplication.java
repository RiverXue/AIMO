package com.aimo.membership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.aimo")
public class AimoMembershipApplication {

    public static void main(String[] args) {
        SpringApplication.run(AimoMembershipApplication.class, args);
    }

}