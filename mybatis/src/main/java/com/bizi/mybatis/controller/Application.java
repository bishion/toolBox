package com.bizi.mybatis.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@ImportResource("classpath:config/spring/*.xml")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
