package com.hyzg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "com.hyzg.mapper")
public class ManagerServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerServerApplication.class,args);
    }
}
