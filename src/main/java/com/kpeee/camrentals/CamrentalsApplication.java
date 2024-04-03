package com.kpeee.camrentals;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kpeee.camrentals.Mapper")
public class CamrentalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamrentalsApplication.class, args);
    }

}
