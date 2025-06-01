package com.project_service.services;

import com.project_service.models.Categorie;
import com.project_service.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServices {

    @Autowired
    private CategorieRepository categorieRepository;

    // Post : Créer une catégorie
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    // Get : Récupérer toutes les catégories
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    // Get : Récupérer une catégorie par ID
    public Optional<Categorie> getCategorieById(Long id) {
        return categorieRepository.findById(id);
    }

    // Put : Mettre à jour une catégorie
    public Categorie updateCategorie(Long id, Categorie updatedCategorie) {
        return categorieRepository.findById(id).map(categorie -> {
            categorie.setLibelle(updatedCategorie.getLibelle());
            categorie.setDescription(updatedCategorie.getDescription());
            categorie.setBilanAnnuel(updatedCategorie.getBilanAnnuel());
            categorie.setNiveauAcademique(updatedCategorie.getNiveauAcademique());
            categorie.setDocument(updatedCategorie.getDocument());
            return categorieRepository.save(categorie);
        }).orElseGet(() -> {
            updatedCategorie.setId(id);
            return categorieRepository.save(updatedCategorie);
        });
    }

    // Delete : Supprimer une catégorie
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}
