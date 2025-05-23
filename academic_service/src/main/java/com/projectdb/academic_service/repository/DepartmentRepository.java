package com.projectdb.academic_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projectdb.academic_service.model.Department;
import java.util.Optional;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);
}
