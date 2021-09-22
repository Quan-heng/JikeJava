package com.quan.week07_homework_09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Week07Homework09Application {

    public static void main(String[] args) {
        SpringApplication.run(Week07Homework09Application.class, args);
    }

}
