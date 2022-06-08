package com.shiki;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shiki.dao")
public class OrderingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderingSystemApplication.class, args);
    }

}
