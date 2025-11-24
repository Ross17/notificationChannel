package com.tymex.test.notifications.controller;

import com.tymex.test.notifications.serviceImpl.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public String sendNotification(@RequestParam String userId, @RequestParam String message) {
        notificationService.notifyUser(userId, message);
        return "Notification sent (if enabled for user).";
    }
}
