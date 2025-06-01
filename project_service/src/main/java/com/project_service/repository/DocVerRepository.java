package com.project_service.repository;

import com.project_service.models.DocVer;
import com.project_service.models.DocVerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocVerRepository extends JpaRepository<DocVer, DocVerId> {
}
