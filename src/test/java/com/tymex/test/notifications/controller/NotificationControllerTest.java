package com.tymex.test.notifications.controller;

import com.tymex.test.notifications.serviceImpl.NotificationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NotificationControllerTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private NotificationController notificationController;

    @Test
    void shouldSendNotificationAndReturnConfirmationMessage() {
        String userId = "user123";
        String message = "Hello, world!";

        String result = notificationController.sendNotification(userId, message);
        assertEquals("Notification sent (if enabled for user).", result);
        verify(notificationService, times(1)).notifyUser(userId, message);
    }
}
