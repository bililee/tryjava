package com.lee.world;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lee.world.mapper")
public class AccessworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessworldApplication.class, args);
    }
}
