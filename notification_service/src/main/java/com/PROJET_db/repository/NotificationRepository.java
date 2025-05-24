package com.PROJET_db.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.PROJET_db.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(String userId); 
}