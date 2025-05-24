package com.PROJET_db.controller;

import org.springframework.web.bind.annotation.*;
import com.PROJET_db.dto.NotificationRequest;
import com.PROJET_db.model.Notification;
import com.PROJET_db.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public Notification send(@RequestBody NotificationRequest request) {
        return service.sendNotification(request);
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getUserNotifications(@PathVariable String userId) {
        return service.getNotificationsByUserId(userId);
    }
}

