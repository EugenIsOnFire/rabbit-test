package com.example.service;

import com.example.common.entity.MessageModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final RabbitMQProducerServiceImpl rabbitMQProducerService;

    private final ObjectMapper objectMapper;

    public void sendCarInfo(MessageModel messageModel) {
        String carInfoInLine = tryToSerialyzeMessageAsString(messageModel);
        if (messageModel.getModelInfo().equals("BMW")) {
            rabbitMQProducerService.sendMessage(carInfoInLine, "light.car");
        } else {
            rabbitMQProducerService.sendMessage(carInfoInLine, "height.car");
        }
    }

    private String tryToSerialyzeMessageAsString(MessageModel messageModel) {
        String carInfoInLine = null;
        try {
            carInfoInLine = objectMapper.writeValueAsString(messageModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return carInfoInLine;
    }
}
