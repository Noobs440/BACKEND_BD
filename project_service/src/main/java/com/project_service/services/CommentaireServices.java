package com.project_service.services;

import com.project_service.models.Commentaire;
import com.project_service.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireServices {

    @Autowired
    private CommentaireRepository commentaireRepository;

    // Post Créer un nouveau commentaire
    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    //Get Récupérer tous les commentaires
    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    // Get Récupérer un commentaire par ID
    public Optional<Commentaire> getCommentaireById(Long id) {
        return commentaireRepository.findById(id);
    }

    // Put Mettre à jour un commentaire existant
    public Commentaire updateCommentaire(Long id, Commentaire updatedCommentaire) {
        return commentaireRepository.findById(id).map(commentaire -> {
            commentaire.setContenue(updatedCommentaire.getContenue());
            commentaire.setDatePublication(updatedCommentaire.getDatePublication());
            commentaire.setHeurePublication(updatedCommentaire.getHeurePublication());
            commentaire.setDocument(updatedCommentaire.getDocument());
            return commentaireRepository.save(commentaire);
        }).orElseGet(() -> {
            updatedCommentaire.setId(id);
            return commentaireRepository.save(updatedCommentaire);
        });
    }

    // Delete Supprimer un commentaire par ID
    public void deleteCommentaire(Long id) {
        commentaireRepository.deleteById(id);
    }
}
