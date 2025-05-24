package com.PROJET_db.service;

import org.springframework.stereotype.Service;
import com.PROJET_db.dto.NotificationRequest;
import com.PROJET_db.model.Notification;
import com.PROJET_db.repository.NotificationRepository;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Notification sendNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .userId(request.getUserId())
                .recipient(request.getRecipient())
                .message(request.getMessage())
                .status("SENT")
                .sentAt(LocalDateTime.now())
                .build();

        return repository.save(notification);
    }

    public List<Notification> getNotificationsByUserId(String userId) {
        return repository.findByUserId(userId);
    }
}


