package com.example.dailycrispme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DailyCrispMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyCrispMeApplication.class, args);
    }

}
