package com.hy.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "com.hy.it.mapper")
public class GoodsServer {
    public static void main(String[] args) {
        SpringApplication.run(GoodsServer.class,args);
    }
}
