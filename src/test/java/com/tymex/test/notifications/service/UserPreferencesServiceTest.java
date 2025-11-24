package com.tymex.test.notifications.service;

import com.tymex.test.notifications.dto.UserPreferences;
import com.tymex.test.notifications.serviceImpl.UserPreferencesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserPreferencesServiceTest {

    @InjectMocks
    private UserPreferencesService service;

    @Test
    void shouldReturnCorrectPreferencesForKnownUser() {
        UserPreferences prefs1 = service.getUserPreferences("user1");
        assertEquals("user1", prefs1.getUserId());
        assertEquals(Set.of("EMAIL"), prefs1.getEnabledChannels());

        UserPreferences prefs2 = service.getUserPreferences("user2");
        assertEquals("user2", prefs2.getUserId());
        assertEquals(Set.of("SMS"), prefs2.getEnabledChannels());

        UserPreferences prefs3 = service.getUserPreferences("user3");
        assertEquals("user3", prefs3.getUserId());
        assertEquals(Set.of("EMAIL", "SMS"), prefs3.getEnabledChannels());
    }

    @Test
    void shouldReturnDefaultPreferencesForUnknownUser() {
        UserPreferences prefs = service.getUserPreferences("unknownUserId");
        assertEquals("unknownUserId", prefs.getUserId());
        assertEquals(Set.of("EMAIL"), prefs.getEnabledChannels());
    }
}
