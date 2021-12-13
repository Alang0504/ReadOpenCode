package com.example.read_open_code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.read_open_code.dao")
@EnableScheduling
public class ReadOpenCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadOpenCodeApplication.class, args);
    }

}
