package com.projectdb.academic_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Filiere")
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Filiere() {}

    public Filiere(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
