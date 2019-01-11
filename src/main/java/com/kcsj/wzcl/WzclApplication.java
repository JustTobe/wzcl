package com.kcsj.wzcl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan( "com.kcsj.wzcl.mapper")
public class WzclApplication extends WebMvcConfigurationSupport {
    /**
     *
     @Override
     protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
     configurer.favorParameter(false);
     configurer.favorPathExtension(false);
     }
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run(WzclApplication.class, args);
    }
}
