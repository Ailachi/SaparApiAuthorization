package com.example.saparauthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SaparAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaparAuthorizationApplication.class, args);
    }

}
