package com.project_service.models;

import jakarta.persistence.*;

@Entity
@Table(name = "evenement")
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ajout;
    private String suppression;
    private String modification;

    @ManyToOne
    @JoinColumn(name = "idDocument")
    private Document document;

    // Getters
    public Long getId() {
        return id;
    }

    public String getAjout() {
        return ajout;
    }

    public String getSuppression() {
        return suppression;
    }

    public String getModification() {
        return modification;
    }

    public Document getDocument() {
        return document;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setAjout(String ajout) {
        this.ajout = ajout;
    }

    public void setSuppression(String suppression) {
        this.suppression = suppression;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
/*
    "ajout":"je vais valider BD",
    "suppression":"",
    "modification":"",
    "document":{
        "id":3
        }
*/