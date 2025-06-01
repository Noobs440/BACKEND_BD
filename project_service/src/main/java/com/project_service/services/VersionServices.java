package com.project_service.services;

import com.project_service.models.Version;
import com.project_service.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersionServices {

    @Autowired
    private VersionRepository versionRepository;

    public Version createVersion(Version version) {
        return versionRepository.save(version);
    }

    public List<Version> getAllVersions() {
        return versionRepository.findAll();
    }

    public Optional<Version> getVersionById(Long id) {
        return versionRepository.findById(id);
    }

    public Version updateVersion(Long id, Version updatedVersion) {
        return versionRepository.findById(id).map(version -> {
            version.setNumeroVersion(updatedVersion.getNumeroVersion());
            version.setDateModification(updatedVersion.getDateModification());
            return versionRepository.save(version);
        }).orElseGet(() -> {
            updatedVersion.setId(id);
            return versionRepository.save(updatedVersion);
        });
    }

    public void deleteVersion(Long id) {
        versionRepository.deleteById(id);
    }
}
