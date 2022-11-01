package com.chenhua.modules;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.chenhua.modules.access.mapper")
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class EmployApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployApplication.class,args);
    }

}
