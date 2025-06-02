package com.projectdb.academic_service.dto;

import com.projectdb.academic_service.model.Filiere;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FiliereDTO {

    private Long id;

    @NotBlank(message = "Le nom de la filiere est obligatoire")
    @Size(min = 3, max = 50, message = "Le nom doit contenir entre 3 et 50 caractères")
    private String name;

    public FiliereDTO() {}

    public FiliereDTO(Filiere filiere) {
        this.id = filiere.getId();
        this.name = filiere.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
