package com.quan.week07.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyBatisPlusConfig {
    @Bean
    public EasySqlInjector easySqlInjector(){
        return new EasySqlInjector();
    }
}
