package com.codecool.stockappspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class StockAppSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockAppSpringBootApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {

    }
}
