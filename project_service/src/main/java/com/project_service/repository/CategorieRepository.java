package com.project_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project_service.models.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository <Categorie, Long>{
}