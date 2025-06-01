package com.project_service.controllers;

import com.project_service.models.DocVer;
import com.project_service.models.DocVerId;
import com.project_service.services.DocVerServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/docvers")
public class DocVerController {

    private final DocVerServices docVerService;

    public DocVerController(DocVerServices docVerService) {
        this.docVerService = docVerService;
    }
    // Get
    @GetMapping
    public List<DocVer> getAll() {
        return docVerService.findAll();
    }
    // Get
    @GetMapping("/{docId}/{verId}")
    public ResponseEntity<DocVer> getById(@PathVariable Long docId, @PathVariable Long verId) {
        DocVerId id = new DocVerId(docId, verId);
        Optional<DocVer> docVer = docVerService.findById(id);
        return docVer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    // Post
    @PostMapping
    public DocVer create(@RequestBody DocVer docVer) {
        return docVerService.save(docVer);
    }
    // Delete
    @DeleteMapping("/{docId}/{verId}")
    public ResponseEntity<Void> delete(@PathVariable Long docId, @PathVariable Long verId) {
        DocVerId id = new DocVerId(docId, verId);
        docVerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
