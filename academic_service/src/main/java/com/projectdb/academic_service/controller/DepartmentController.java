package com.projectdb.academic_service.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

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

    Department created = service.createDepartment(departmentDTO);
    return ResponseEntity.ok(new DepartmentDTO(created));
}
    @GetMapping
    public List<DepartmentDTO> getAll() {
        return service.getAll().stream()
                .map(DepartmentDTO::new)
                .toList();
    }


    @GetMapping("/{id}")
    public DepartmentDTO getById(@PathVariable Long id) {
        Department department = service.getById(id);
        return new DepartmentDTO(department);
    }


    @PutMapping("/{id}")
    public DepartmentDTO update(@PathVariable Long id, @RequestBody DepartmentDTO dto) {
        Department updated = service.updateDepartment(id, dto);
        return new DepartmentDTO(updated);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
