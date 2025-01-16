package com.example.demo.domain.home.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HomeConfig2 {

    @Bean
    public List<Integer> numList2(List<Integer> numList) {
        return numList.reversed();
    }
}
