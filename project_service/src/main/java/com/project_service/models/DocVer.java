package com.project_service.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "docVer")
@IdClass(DocVerId.class)
public class DocVer {

    @Id
    @Column(name = "doc_id")
    private Long docId;

    @Id
    @Column(name = "ver_id")
    private Long verId;

    @Column(name = "date_mise_ajour")
    private LocalDate dateMiseAjour;

    // Constructeurs
    public DocVer() {}

    public DocVer(Long docId, Long verId, LocalDate dateMiseAjour) {
        this.docId = docId;
        this.verId = verId;
        this.dateMiseAjour = dateMiseAjour;
    }

    // Getters et setters

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getVerId() {
        return verId;
    }

    public void setVerId(Long verId) {
        this.verId = verId;
    }

    public LocalDate getDateMiseAjour() {
        return dateMiseAjour;
    }

    public void setDateMiseAjour(LocalDate dateMiseAjour) {
        this.dateMiseAjour = dateMiseAjour;
    }
}

/*
     "docId":4,
        "verId":2,
    "dateMiseAjour":"2025-05-25"
*/