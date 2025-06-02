package com.projectdb.academic_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projectdb.academic_service.model.Filiere;
import java.util.Optional;


public interface FiliereRepository extends JpaRepository<Filiere, Long> {
    Optional<Filiere> findByName(String name);
}
