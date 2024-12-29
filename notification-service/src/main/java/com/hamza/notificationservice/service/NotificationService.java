package com.hamza.notificationservice.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final JavaMailSender mailSender;

    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendNotification(String resultMessage) {
        // Log the notification
        System.out.println("Sending notification: " + resultMessage);

        // Send an email notification
        try {
            sendEmail(resultMessage);
        } catch (MessagingException e) {
            System.err.println("Failed to send email notification: " + e.getMessage());
        }
    }

    private void sendEmail(String resultMessage) throws MessagingException {
        // Create a new email message
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Configure email parameters
        helper.setTo("recipient@example.com"); // Replace with the recipient's email address
        helper.setSubject("Computation Result Notification");
        helper.setText("Here is the computation result:\n\n" + resultMessage);

        // Send the email
        mailSender.send(message);
        System.out.println("Email sent successfully.");
    }
}
