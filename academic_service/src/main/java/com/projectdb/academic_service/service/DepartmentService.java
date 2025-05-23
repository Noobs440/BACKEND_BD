package com.projectdb.academic_service.service;

import com.projectdb.academic_service.model.Department;
import com.projectdb.academic_service.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

     public Department createDepartment(Department department) {
        Optional<Department> existingDepartment = repository.findByName(department.getName());
        if (existingDepartment.isPresent()) {
            throw new RuntimeException("Ce département existe déjà.");
        }
        return repository.save(department);
    }

    public List<Department> getAll() {
        return repository.findAll();
    }

    public Department getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
