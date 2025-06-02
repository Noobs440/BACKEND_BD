package com.projectdb.academic_service.service;

import com.projectdb.academic_service.exception.DepartmentAlreadyExistsException;
import com.projectdb.academic_service.dto.DepartmentDTO;
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

    public Department createDepartment(DepartmentDTO dto) {
        Optional<Department> existingDepartment = repository.findByName(dto.getName());
        if (existingDepartment.isPresent()) {
            throw new DepartmentAlreadyExistsException("Ce département existe déjà.");
        }
        Department department = new Department();
        department.setName(dto.getName());
        return repository.save(department);
    }

    public List<Department> getAll() {
        return repository.findAll();
    }

    public Department getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Department updateDepartment(Long id, DepartmentDTO dto) {
        Department existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Département non trouvé avec l'ID : " + id));

        Optional<Department> existingByName = repository.findByName(dto.getName());
        if (existingByName.isPresent() && !existingByName.get().getId().equals(id)) {
            throw new DepartmentAlreadyExistsException("Un autre département avec ce nom existe déjà.");
        }

        existing.setName(dto.getName());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
