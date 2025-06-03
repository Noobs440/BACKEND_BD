package com.PROJET_db.file_service.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;



@Entity
@Table(name = "document")
public class Doc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="identifiant")
    private Long id_fic;        //je dois chercher si je dois mettre @column

    @Column(name="projet_id", nullable = false)
    private Long projetId;

    @Column(name="type_fic", nullable = false)
    private String type; // "photo" ou "document"

    @Column(name="nom_fichier", nullable = false)
    private String nomFichier;

    @Column(name = "chemin_fichier", nullable = false)
    private String cheminFichier;

    @Column(name="taille_fic", nullable = false)
    private Long taille;

    @Column(name="format_fic", nullable = false)
    private String format;

    @Column(name="date_upload", nullable = false)
    private LocalDateTime dateUpload;

    @Lob
    @Column(name = "data", nullable = false)
    private byte[] data;

    //@OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Droit> droits = new ArrayList<>(); 
    //gerer les getters et setters pour les droits

    public Doc() {}

    public Doc(Long projetId, String type, String nomFichier, String cheminFichier, Long taille, String format, LocalDateTime dateUpload) {
        this.projetId = projetId;
        this.type = type;
        this.nomFichier = nomFichier;
        this.cheminFichier = cheminFichier;
        this.taille = taille;
        this.format = format;
        this.dateUpload = dateUpload;
    }

    // Getters et Setters
   public Long getId() {
        return id_fic;
    }

    public void setId(long id) {
        this.id_fic = id;
    }

    public Long getProjetId() {
        return projetId;
    }

    public void setProjetId(Long projetId) {
        this.projetId = projetId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public String getCheminFichier() {
        return cheminFichier;
    }

    public void setCheminFichier(String cheminFichier) {
        this.cheminFichier = cheminFichier;
    }

    public Long getTaille() {
        return taille;
    }

    public void setTaille(Long taille) {
        this.taille = taille;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public LocalDateTime getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(LocalDateTime dateUpload) {
        this.dateUpload = dateUpload;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
