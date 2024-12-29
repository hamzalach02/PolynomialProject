package com.hamza.notificationservice.kafka;

import com.hamza.notificationservice.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ResultConsumer {

    private final NotificationService notificationService;

    public ResultConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "result-topic", groupId = "notification-group")
    public void consumeResult(String resultMessage) {
        // Log the received message
        System.out.println("Received result from Kafka: " + resultMessage);

        // Send a notification (e.g., email or log)
        notificationService.sendNotification(resultMessage);
    }
}
