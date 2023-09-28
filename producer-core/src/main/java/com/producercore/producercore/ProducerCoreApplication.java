package com.producercore.producercore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.producercore")
public class ProducerCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerCoreApplication.class, args);
    }

}
