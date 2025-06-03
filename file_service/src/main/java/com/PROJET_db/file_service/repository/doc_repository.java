package com.PROJET_db.file_service.repository;

import com.PROJET_db.file_service.models.Doc;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface doc_repository extends JpaRepository<Doc, Long>{
    Optional<Doc> findById(Long id);
}