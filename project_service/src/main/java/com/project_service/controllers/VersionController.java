package com.project_service.controllers;

import com.project_service.models.Version;
import com.project_service.services.VersionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/versions")
public class VersionController {

    @Autowired
    private VersionServices versionService;

    @PostMapping
    public ResponseEntity<Version> createVersion(@RequestBody Version version) {
        return ResponseEntity.ok(versionService.createVersion(version));
    }

    @GetMapping
    public ResponseEntity<List<Version>> getAllVersions() {
        return ResponseEntity.ok(versionService.getAllVersions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Version> getVersionById(@PathVariable Long id) {
        Optional<Version> version = versionService.getVersionById(id);
        return version.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Version> updateVersion(@PathVariable Long id, @RequestBody Version version) {
        return ResponseEntity.ok(versionService.updateVersion(id, version));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVersion(@PathVariable Long id) {
        versionService.deleteVersion(id);
        return ResponseEntity.noContent().build();
    }
}
