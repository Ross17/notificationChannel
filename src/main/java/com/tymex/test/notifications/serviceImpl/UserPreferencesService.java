package com.tymex.test.notifications.serviceImpl;

import com.tymex.test.notifications.dto.UserPreferences;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class UserPreferencesService {

    private final Map<String, UserPreferences> database = new HashMap<>();

    public UserPreferencesService() {
        database.put("user1", new UserPreferences("user1", Set.of("EMAIL")));
        database.put("user2", new UserPreferences("user2", Set.of("SMS")));
        database.put("user3", new UserPreferences("user3", Set.of("EMAIL", "SMS")));
    }

    public UserPreferences getUserPreferences(String userId) {
        return database.getOrDefault(userId, new UserPreferences(userId, Set.of("EMAIL"))); // default EMAIL
    }
}
