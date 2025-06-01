package com.project_service.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String titre;
    private String description;
    private String statut;
    private String filiere;
    private String datePublication;

    // Getters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getStatut() {
        return statut;
    }

    public String getFiliere(){
        return filiere;
    }

    public String getDatePublication() {
        return datePublication;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setFiliere(String filiere){
        this.filiere = filiere;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }
}

/*
{
    "nom": "base de donne",
    "titre": "valider",
    "description": "controle continue",
    "statut": "18/20",
    "datePublication": "26-05-2025"
}
*/