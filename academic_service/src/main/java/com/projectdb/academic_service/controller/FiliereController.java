package com.projectdb.academic_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import com.projectdb.academic_service.dto.FiliereDTO;
import com.projectdb.academic_service.model.Filiere;
import com.projectdb.academic_service.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    @Autowired
    private FiliereService service;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody FiliereDTO filiereDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }

        Filiere filiere = new Filiere();
        filiere.setName(filiereDTO.getName());

        Filiere created = service.createFiliere(filiereDTO);
        return ResponseEntity.ok(new FiliereDTO(created));
    }

    @GetMapping
    public List<FiliereDTO> getAll() {
        return service.getAll().stream()
                .map(FiliereDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public FiliereDTO getById(@PathVariable Long id) {
        Filiere filiere = service.getById(id);
        return new FiliereDTO(filiere);
    }

    @PutMapping("/{id}")
    public FiliereDTO update(@PathVariable Long id, @RequestBody FiliereDTO dto) {
        Filiere updated = service.updateFiliere(id, dto);
        return new FiliereDTO(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
