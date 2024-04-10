package com.cr.app.techniquetestsolution.Services;

import com.cr.app.techniquetestsolution.Entities.Author;
import org.springframework.http.ResponseEntity;

public interface AuthorService {
    ResponseEntity<String> createAuthor(Author author);
    ResponseEntity<Object> getAllAuthors();
    ResponseEntity<Object> setDocumentToAuthor(String name, String lastName, Long documentId);
    ResponseEntity<Object> getAuthorByName(String name, String lastName);
    ResponseEntity<String> updateAuthor(Long id, Author author);
    ResponseEntity<String> deleteAuthor(Long id);

}
