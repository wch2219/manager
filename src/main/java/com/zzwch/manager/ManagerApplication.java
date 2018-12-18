package com.zzwch.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManagerApplication extends ServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

}

