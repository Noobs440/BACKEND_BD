package com.PROJET_db.file_service.services;

import com.PROJET_db.file_service.models.Doc;
import com.PROJET_db.file_service.repository.doc_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DocService {

    @Autowired
    private doc_repository docRepository;

    /**
     * Sauvegarde un document (métadonnées + contenu BLOB)
     */
    public Doc save(Doc doc) {
        if (doc.getDateUpload() == null) {
            doc.setDateUpload(LocalDateTime.now());
        }
        return docRepository.save(doc);
    }

    /**
     * Récupère le contenu d'un document sous forme de Resource
     */
    public Optional<Resource> loadAsResource(Long id) {
        return docRepository.findById(id)
                .map(doc -> {
                    try {
                        Path path = Paths.get(doc.getCheminFichier());
                        UrlResource resource = new UrlResource(path.toUri());
                        if (resource.exists() && resource.isReadable()) {
                            return (Resource) resource;
                        }
                    } catch (Exception e) {
                        // loger l'erreur
                    }
                    return null;
                });
    }

    /**
     * Retourne toutes les métadonnées des documents
     */
    public List<Doc> findAll() {
        return docRepository.findAll();
    }

    /**
     * Retourne un document si existant
     */
    public Optional<Doc> findById(Long id) {
        return docRepository.findById(id);
    }

    /**
     * Supprime un document en base et supprime le fichier si nécessaire
     */
    public boolean delete(Long id) {
        Optional<Doc> opt = docRepository.findById(id);
        if (opt.isPresent()) {
            docRepository.deleteById(id);
            // Optionnel: suppression physique si stocké en FS
            Path path = Paths.get(opt.get().getCheminFichier());
            try {
                Files.deleteIfExists(path);
            } catch (Exception e) {
                // loger l'erreur
            }
            return true;
        }
        return false;
    }
}
