package com.autohome.autoracing;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.autohome.autoracing.mapper")
public class AutoRacingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoRacingApplication.class, args);
    }

}
