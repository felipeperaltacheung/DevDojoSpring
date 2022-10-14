package com.example.devdojospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.devdojospring.start") // para alterar o local do main -> ex. /start/SpringApplication
public class DevDojoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevDojoSpringApplication.class, args);
    }

}
