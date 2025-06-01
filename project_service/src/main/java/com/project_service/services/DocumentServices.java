package com.project_service.services;

import com.project_service.models.Document;
import com.project_service.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServices {

    @Autowired
    private DocumentRepository documentRepository;

    // Créer un nouveau document
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    // Obtenir la liste de tous les documents
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    // Obtenir un document par ID
    public Optional<Document> getDocumentById(Long id) {
        return documentRepository.findById(id);
    }

    // Supprimer un document par ID
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    // Mettre à jour un document
    public Document updateDocument(Long id, Document updatedDocument) {
        return documentRepository.findById(id).map(document -> {
            document.setNom(updatedDocument.getNom());
            document.setTitre(updatedDocument.getTitre());
            document.setDescription(updatedDocument.getDescription());
            document.setStatut(updatedDocument.getStatut());
            document.setFiliere(updatedDocument.getFiliere());
            document.setDatePublication(updatedDocument.getDatePublication());
            return documentRepository.save(document);
        }).orElseGet(() -> {
            updatedDocument.setId(id);
            return documentRepository.save(updatedDocument);
        });
    }
}
