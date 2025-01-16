package com.example.demo.domain.home.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HomeConfig {

    @Bean
    public List<Integer> numList() {
        return List.of(10, 20, 30, 40, 50);
    }
}
