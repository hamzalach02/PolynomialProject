package com.hamza.resultservice.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hamza.resultservice.model.ComputationResult;
import com.hamza.resultservice.service.ResultService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ResultConsumer {

    private final ResultService resultService;
    private final ObjectMapper objectMapper;

    public ResultConsumer(ResultService resultService, ObjectMapper objectMapper) {
        this.resultService = resultService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "polynomial-input-topic", groupId = "result-group")
    public void consumeMessage(String message) {
        try {
            // Deserialize the message
            ComputationResult result = objectMapper.readValue(message, ComputationResult.class);

            // Save the result to the database
            resultService.saveResult(result);

            System.out.println("Saved result: " + result);
        } catch (Exception e) {
            System.err.println("Error consuming Kafka message: " + e.getMessage());
        }
    }
}
