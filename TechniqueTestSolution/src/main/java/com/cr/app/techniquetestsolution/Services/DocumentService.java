package com.cr.app.techniquetestsolution.Services;

import com.cr.app.techniquetestsolution.Entities.Author;
import com.cr.app.techniquetestsolution.Entities.DocumentEntity;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface DocumentService {
    ResponseEntity<Object> getAllDocs();
    ResponseEntity<Object> getDocByName(String name);
    ResponseEntity<String> updateDoc(DocumentEntity documentEntity);
    ResponseEntity<String> deleteDoc(Long id);
    ResponseEntity<String> createDoc(DocumentEntity documentEntity);

    Set<Author> verifyExistOrNotAuthor(Set<Author> authors);
}
