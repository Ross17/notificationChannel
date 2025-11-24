package com.tymex.test.notifications.serviceImpl;

import com.tymex.test.notifications.service.NotificationChannel;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationChannel implements NotificationChannel {

    @Override
    public void sendNotification(String userId, String message) {
        // Integrate SMS provider SDK or API here
        System.out.println("Sending SMS to user " + userId + ": " + message);
    }
}