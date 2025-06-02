package com.projectdb.academic_service.controller;

import com.projectdb.academic_service.dto.DepartmentDTO;
import com.projectdb.academic_service.model.Department;
import com.projectdb.academic_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DepartmentDTO departmentDTO, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        String errorMessage = bindingResult.getFieldError().getDefaultMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }

    Department department = new Department();
    department.setName(departmentDTO.getName());

    Department created = service.createDepartment(department);
    return ResponseEntity.ok(created);
}

    @GetMapping
    public List<Department> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @RequestBody DepartmentDTO dto) {
        return service.updateDepartment(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
