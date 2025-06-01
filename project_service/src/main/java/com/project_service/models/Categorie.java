package com.project_service.models;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private String description;
    private String bilanAnnuel;
    private String niveauAcademique;
    // OneToOne n'est pas approprier
    @ManyToOne
    @JoinColumn(name = "idDocument")
    private Document document;

    // Getters
    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDescription() {
        return description;
    }

    public String getBilanAnnuel() {
        return bilanAnnuel;
    }

    public String getNiveauAcademique(){
        return niveauAcademique;
    }

    public Document getDocument() {
        return document;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBilanAnnuel(String bilanAnnuel) {
        this.bilanAnnuel = bilanAnnuel;
    }

    public void setNiveauAcademique(String niveauAcademique){
        this.niveauAcademique = niveauAcademique;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}

/*
    "id":2,
    "libelle":"je vais valider BD",
    "description":"j'ai eu un pb sur la migration des cles primaires",
    "bilanAnnuel":"j'ai valide BD",
    "niveauAcademique":1,
    "document":{
        "id":2
        }
*/