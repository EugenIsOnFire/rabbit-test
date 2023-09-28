package com.example.service;

public interface RabbitMQProducerService {

    void sendMessage(String message, String routingKey);

}
