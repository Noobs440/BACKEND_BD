// package com.project_service.services;

// import com.project_service.models.Evenement;
// import com.project_service.repository.EvenementRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class EvenementServices {

//     @Autowired
//     private EvenementRepository evenementRepository;

//     // Créer un nouveau evenement
//     public Evenement saveEvenement(Evenement document) {
//         return documentRepository.save(document);
//     }

//     // Obtenir la liste de tous les documents
//     public List<Document> getAllDocuments() {
//         return documentRepository.findAll();
//     }

//     // Obtenir un document par ID
//     public Optional<Document> getDocumentById(Long id) {
//         return documentRepository.findById(id);
//     }

//     // Supprimer un document par ID
//     public void deleteDocument(Long id) {
//         documentRepository.deleteById(id);
//     }

//     // Mettre à jour un document
//     public Document updateDocument(Long id, Document updatedDocument) {
//         return documentRepository.findById(id).map(document -> {
//             document.setNom(updatedDocument.getNom());
//             document.setTitre(updatedDocument.getTitre());
//             document.setDescription(updatedDocument.getDescription());
//             document.setStatut(updatedDocument.getStatut());
//             document.setDatePublication(updatedDocument.getDatePublication());
//             return documentRepository.save(document);
//         }).orElseGet(() -> {
//             updatedDocument.setId(id);
//             return documentRepository.save(updatedDocument);
//         });
//     }
// }
package com.project_service.services;

import com.project_service.models.Evenement;
import com.project_service.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvenementServices {

    @Autowired
    private EvenementRepository evenementRepository;

    public Evenement createEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    public Optional<Evenement> getEvenementById(Long id) {
        return evenementRepository.findById(id);
    }

    public Evenement updateEvenement(Long id, Evenement updatedEvenement) {
        return evenementRepository.findById(id).map(evenement -> {
            evenement.setAjout(updatedEvenement.getAjout());
            evenement.setSuppression(updatedEvenement.getSuppression());
            evenement.setModification(updatedEvenement.getModification());
            evenement.setDocument(updatedEvenement.getDocument());
            return evenementRepository.save(evenement);
        }).orElseGet(() -> {
            updatedEvenement.setId(id);
            return evenementRepository.save(updatedEvenement);
        });
    }

    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }
}
