package com.tymex.test.notifications.dto;

import java.util.Set;

public class UserPreferences {
    private String userId;
    private Set<String> enabledChannels;  // e.g. {"EMAIL", "SMS"}

    public UserPreferences(String userId, Set<String> enabledChannels) {
        this.userId = userId;
        this.enabledChannels = enabledChannels;
    }

    public String getUserId() { return userId; }
    public Set<String> getEnabledChannels() { return enabledChannels; }
}
