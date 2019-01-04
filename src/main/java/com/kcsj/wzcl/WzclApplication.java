package com.kcsj.wzcl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan( "com.kcsj.wzcl.mapper")
public class WzclApplication {

    public static void main(String[] args) {
        SpringApplication.run(WzclApplication.class, args);
    }
}
