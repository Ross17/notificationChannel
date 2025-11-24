package com.tymex.test.notifications.serviceImpl;

import com.tymex.test.notifications.dto.UserPreferences;
import com.tymex.test.notifications.service.NotificationChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationService {

    private final UserPreferencesService preferencesService;
    private final Map<String, NotificationChannel> channels;

    @Autowired
    public NotificationService(UserPreferencesService preferencesService,
                               EmailNotificationChannel emailChannel,
                               SmsNotificationChannel smsChannel) {
        this.preferencesService = preferencesService;
        this.channels = Map.of(
                "EMAIL", emailChannel,
                "SMS", smsChannel
        );
    }

    public void notifyUser(String userId, String message) {
        UserPreferences preferences = preferencesService.getUserPreferences(userId);

        for (String channelKey : preferences.getEnabledChannels()) {
            NotificationChannel channel = channels.get(channelKey);
            if (channel != null) {
                channel.sendNotification(userId, message);
            }
        }
    }
}
