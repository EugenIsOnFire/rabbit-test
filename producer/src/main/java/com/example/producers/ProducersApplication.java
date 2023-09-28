package com.example.producers;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class ProducersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducersApplication.class, args);
    }

}
