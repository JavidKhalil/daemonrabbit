package com.company.rabbitspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RabbitConfiguration.class)
public class RabbitspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitspringApplication.class, args);
    }

}
