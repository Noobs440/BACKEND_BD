package com.project_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project_service.models.Document;

@Repository
public interface DocumentRepository extends JpaRepository <Document, Long>{
} 