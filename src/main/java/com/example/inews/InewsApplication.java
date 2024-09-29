package com.example.inews;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.example.inews.mapper")
@SpringBootApplication
public class InewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InewsApplication.class, args);
    }

}
