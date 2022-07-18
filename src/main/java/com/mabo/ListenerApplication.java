package com.mabo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.mabo.dao")
@SpringBootApplication
public class ListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }
}
