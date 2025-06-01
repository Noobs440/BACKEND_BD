package com.project_service.services;

import com.project_service.models.DocVer;
import com.project_service.models.DocVerId;
import com.project_service.repository.DocVerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocVerServices {

    private final DocVerRepository docVerRepository;
    // Get
    public DocVerServices(DocVerRepository docVerRepository) {
        this.docVerRepository = docVerRepository;
    }
    // Get
    public List<DocVer> findAll() {
        return docVerRepository.findAll();
    }
    // Put
    public Optional<DocVer> findById(DocVerId id) {
        return docVerRepository.findById(id);
    }
    // Post
    public DocVer save(DocVer docVer) {
        return docVerRepository.save(docVer);
    }
    // Delete
    public void deleteById(DocVerId id) {
        docVerRepository.deleteById(id);
    }
}
