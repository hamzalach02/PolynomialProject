package com.hamza.computationservice.kafka;

import com.hamza.computationservice.model.ComputationResult;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResultProducer {
    private final KafkaTemplate<String, ComputationResult> kafkaTemplate;

    public ResultProducer(KafkaTemplate<String, ComputationResult> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendResult(ComputationResult result) {
        kafkaTemplate.send("result-topic", result);
    }
}
