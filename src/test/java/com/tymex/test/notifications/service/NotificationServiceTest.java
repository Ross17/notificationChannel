package com.tymex.test.notifications.service;

import com.tymex.test.notifications.dto.UserPreferences;
import com.tymex.test.notifications.serviceImpl.EmailNotificationChannel;
import com.tymex.test.notifications.serviceImpl.NotificationService;
import com.tymex.test.notifications.serviceImpl.SmsNotificationChannel;
import com.tymex.test.notifications.serviceImpl.UserPreferencesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @Mock
    private UserPreferencesService preferencesService;

    @Mock
    private EmailNotificationChannel emailChannel;

    @Mock
    private SmsNotificationChannel smsChannel;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    void shouldNotifyUserByEnabledChannels() {
        String userId = "user123";
        String message = "Hello!";
        UserPreferences preferences = mock(UserPreferences.class);
        when(preferencesService.getUserPreferences(userId)).thenReturn(preferences);
        when(preferences.getEnabledChannels()).thenReturn(Set.of("EMAIL", "SMS"));

        notificationService.notifyUser(userId, message);

        verify(emailChannel).sendNotification(userId, message);
        verify(smsChannel).sendNotification(userId, message);
    }

}
