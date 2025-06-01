package com.project_service.controllers;

import com.project_service.models.Commentaire;
import com.project_service.services.CommentaireServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireServices commentaireService;

    // POST - Créer un commentaire
    @PostMapping
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire) {
        Commentaire created = commentaireService.createCommentaire(commentaire);
        return ResponseEntity.ok(created);
    }

    // GET - Récupérer tous les commentaires
    @GetMapping
    public ResponseEntity<List<Commentaire>> getAllCommentaires() {
        List<Commentaire> commentaires = commentaireService.getAllCommentaires();
        return ResponseEntity.ok(commentaires);
    }

    // GET - Récupérer un commentaire par ID
    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Long id) {
        Optional<Commentaire> commentaire = commentaireService.getCommentaireById(id);
        return commentaire.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    // PUT - Mettre à jour un commentaire
    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Long id, @RequestBody Commentaire commentaire) {
        Commentaire updated = commentaireService.updateCommentaire(id, commentaire);
        return ResponseEntity.ok(updated);
    }

    // DELETE - Supprimer un commentaire
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable Long id) {
        commentaireService.deleteCommentaire(id);
        return ResponseEntity.noContent().build();
    }
}
