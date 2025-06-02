package com.PROJET_db.file_service.controllers;

import com.PROJET_db.file_service.models.Doc;
import com.PROJET_db.file_service.services.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocController {

    @Autowired
    private DocService docService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Doc> ajouterDocument(
        @RequestParam("file") MultipartFile file,
        @RequestParam("projetId") Long projetId,
        @RequestParam("type") String type
    ) {
        try {
            Doc doc = new Doc();
            doc.setProjetId(projetId);
            doc.setType(type);
            doc.setNomFichier(file.getOriginalFilename());
            doc.setFormat(file.getContentType());
            doc.setTaille(file.getSize());
            doc.setDateUpload(java.time.LocalDateTime.now());
            doc.setData(file.getBytes());

            Doc saved = docService.save(doc);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> recupererDocument(@PathVariable Long id) {
        return docService.loadAsResource(id)
            .map(resource -> {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentDisposition(ContentDisposition
                    .attachment()
                    .filename(resource.getFilename())
                    .build());
                return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Doc> recupererTousDocuments() {
        return docService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerDocument(@PathVariable Long id) {
        return docService.delete(id)
            ? ResponseEntity.noContent().build()
            : ResponseEntity.notFound().build();
    }
}
