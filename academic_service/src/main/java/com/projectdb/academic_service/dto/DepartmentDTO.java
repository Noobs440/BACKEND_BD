package com.projectdb.academic_service.dto;

import com.projectdb.academic_service.model.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "Le nom du département est obligatoire")
    @Size(min = 3, max = 50, message = "Le nom doit contenir entre 3 et 50 caractères")
    private String name;

    public DepartmentDTO() {}

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.name = department.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
