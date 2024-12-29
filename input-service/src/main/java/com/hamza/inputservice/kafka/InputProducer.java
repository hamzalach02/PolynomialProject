package com.hamza.inputservice.kafka;

import com.hamza.inputservice.model.PolynomialInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InputProducer {

    private static final String TOPIC = "polynomial-input-topic";

    @Autowired
    private KafkaTemplate<String, PolynomialInput> kafkaTemplate;

    public void sendMessage(PolynomialInput message) {
        try {
            kafkaTemplate.send(TOPIC, message);
            System.out.println("Message sent to Kafka: " + message);
        } catch (Exception e) {
            System.err.println("Error while sending message to Kafka: " + e.getMessage());
        }
    }
}
