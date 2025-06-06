package com.aimo.social;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.aimo")
//@MapperScan("com.aimo.social.mapper")
public class AimoSocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(AimoSocialApplication.class, args);
    }

}