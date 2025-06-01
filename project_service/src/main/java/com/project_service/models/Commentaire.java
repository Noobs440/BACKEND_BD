package com.project_service.models;

import jakarta.persistence.*;

@Entity
@Table(name = "commentaire")
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenue;
    private String datePublication;
    private String heurePublication;

    //Relation 1 a n entre les tables document et commentaire
    @ManyToOne
    @JoinColumn(name = "idDocument")
    private Document document;

    // Getters
    public Long getId() {
        return id;
    }

    public String getContenue() {
        return contenue;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public String getHeurePublication() {
        return heurePublication;
    }

    public Document getDocument() {
        return document;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public void setHeurePublication(String heurePublication) {
        this.heurePublication = heurePublication;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}

/*
    "id":10,
    "contenue":"je vais valider",
    "datePublication":"26-05-25",
    "heurePublication":"02:02",
    "document":{
        "id":2
        }
*/