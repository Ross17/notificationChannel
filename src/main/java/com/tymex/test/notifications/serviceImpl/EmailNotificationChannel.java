package com.tymex.test.notifications.serviceImpl;

import com.tymex.test.notifications.service.NotificationChannel;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationChannel implements NotificationChannel {

    @Override
    public void sendNotification(String userId, String message) {
        // Integrate email provider SDK or API here
        System.out.println("Sending Email to user " + userId + ": " + message);
    }
}

