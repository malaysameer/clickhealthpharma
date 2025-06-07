package com.clickhealth.pharma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.clickhealth.pharma")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
