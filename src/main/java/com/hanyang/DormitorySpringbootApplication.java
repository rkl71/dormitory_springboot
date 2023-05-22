package com.hanyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hanyang.mapper")
public class DormitorySpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DormitorySpringbootApplication.class, args);
    }

}
