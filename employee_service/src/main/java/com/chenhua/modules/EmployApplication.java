package com.chenhua.modules;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@MapperScan("com.chenhua.modules.access.mapper")
@SpringBootApplication
public class EmployApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployApplication.class,args);
    }

}
