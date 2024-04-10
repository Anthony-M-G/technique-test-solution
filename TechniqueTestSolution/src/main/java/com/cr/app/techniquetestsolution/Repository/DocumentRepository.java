package com.cr.app.techniquetestsolution.Repository;

import com.cr.app.techniquetestsolution.Entities.DocumentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface DocumentRepository extends CrudRepository<DocumentEntity,Long> {
    DocumentEntity findByTitle(String title);
    Set<DocumentEntity> findAll();

    boolean existsByTitle(String title);
}
