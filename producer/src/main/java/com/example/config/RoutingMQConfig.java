package com.example.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingMQConfig {

    @Bean
    public Declarables myQueue() {
        Queue queueFanOutFirst = new Queue("myQueue1", false);
        Queue queueFanOutSecond = new Queue("myQueue2", false);
        DirectExchange fanoutExchange = new DirectExchange("directExchange");

        return new Declarables(queueFanOutFirst, queueFanOutSecond, fanoutExchange,
                BindingBuilder.bind(queueFanOutFirst).to(fanoutExchange).with("light.car"),
                BindingBuilder.bind(queueFanOutSecond).to(fanoutExchange).with("height.car"));
    }

    @Bean
    public Declarables myQueueFanout() {
        Queue queueFanOutFirst = new Queue("myTopicQueue1", false);
        Queue queueFanOutSecond = new Queue("myTopicQueue2", false);
        TopicExchange fanoutExchange = new TopicExchange("topicExchange");

        return new Declarables(queueFanOutFirst, queueFanOutSecond, fanoutExchange,
                BindingBuilder.bind(queueFanOutFirst).to(fanoutExchange).with("light.*"),
                BindingBuilder.bind(queueFanOutSecond).to(fanoutExchange).with("*.car"));
    }
}
