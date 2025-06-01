package com.project_service.models;

import jakarta.persistence.*;

@Entity
@Table(name = "version")
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroVersion;
    private String dateModification;

    // Getters
    public Long getId() {
        return id;
    }

    public String getNumeroVersion() {
        return numeroVersion;
    }

    public String getDateModification() {
        return dateModification;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNumeroVersion(String numeroVersion) {
        this.numeroVersion = numeroVersion;
    }

    public void setDateModification(String dateModification) {
        this.dateModification = dateModification;
    }
}
