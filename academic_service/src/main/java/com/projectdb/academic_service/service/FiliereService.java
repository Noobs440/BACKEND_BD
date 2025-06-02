package com.projectdb.academic_service.service;

import com.projectdb.academic_service.exception.FiliereAlreadyExistsException;
import com.projectdb.academic_service.dto.FiliereDTO;
import com.projectdb.academic_service.model.Filiere;
import com.projectdb.academic_service.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository repository;

    public Filiere createFiliere(FiliereDTO dto) {
        Optional<Filiere> existingFiliere = repository.findByName(dto.getName());
        if (existingFiliere.isPresent()) {
            throw new FiliereAlreadyExistsException("Cette filiere existe déjà.");
        }
        Filiere filiere = new Filiere();
        filiere.setName(dto.getName());
        return repository.save(filiere);
    }

    public List<Filiere> getAll() {
        return repository.findAll();
    }

    public Filiere getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Filiere updateFiliere(Long id, FiliereDTO dto) {
        Filiere existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Filiere non trouvé avec l'ID : " + id));

        Optional<Filiere> existingByName = repository.findByName(dto.getName());
        if (existingByName.isPresent() && !existingByName.get().getId().equals(id)) {
            throw new FiliereAlreadyExistsException("Une autre filiere avec ce nom existe déjà.");
        }

        existing.setName(dto.getName());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
