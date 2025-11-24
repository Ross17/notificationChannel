package com.tymex.test.notifications.service;

public interface NotificationChannel {
    void sendNotification(String userId, String message);
}
