package com.producercore.service;

public interface RabbitMQProducerService {

    void sendMessage(String message, String routingKey);

}
