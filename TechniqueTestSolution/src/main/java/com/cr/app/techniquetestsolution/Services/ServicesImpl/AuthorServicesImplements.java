package com.cr.app.techniquetestsolution.Services.ServicesImpl;

import com.cr.app.techniquetestsolution.Entities.Author;
import com.cr.app.techniquetestsolution.Repository.AuthorRepository;
import com.cr.app.techniquetestsolution.Services.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServicesImplements implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public ResponseEntity<String> createAuthor(Author author) {
        if(authorRepository.existsAuthorByFirstNameAndLastName(author.getFirstName(), author.getLastName())){
            return ResponseEntity.badRequest().body("Author already exists");
        }
        Author authorBD = new Author().builder()
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .build();
        authorRepository.save(authorBD);
        return ResponseEntity.ok().body("Author created successfully");
    }

    @Override
    public ResponseEntity<Object> getAllAuthors() {
        try {
            return ResponseEntity.accepted().body(authorRepository.findAll());
        } catch (DataAccessException e) {
            log.error("Error accessing data", e);
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Hubo un problema con la base de datos");
        }
    }

    @Override
    public ResponseEntity<Object> setDocumentToAuthor(String name, String lastName, Long documentId) {
        return null;
    }

    @Override
    public ResponseEntity<Object> getAuthorByName(String name, String lastName) {
        if(!authorRepository.existsAuthorByFirstNameAndLastName(name, lastName)){
            return ResponseEntity.badRequest().body("Author not found");
        }
        return ResponseEntity.accepted().body(authorRepository.getAuthorByFirstName(name));
    }

    @Override
    public ResponseEntity<String> updateAuthor(Long id, Author author) {
        if(!authorRepository.existsById(id)){
            return ResponseEntity.badRequest().body("Author not found");
        }
        Author authorBD = authorRepository.findById(id).get();
        authorBD.setFirstName(author.getFirstName());
        authorBD.setLastName(author.getLastName());
        authorRepository.save(authorBD);
        return ResponseEntity.ok().body("Author updated successfully");
    }

    @Override
    public ResponseEntity<String> deleteAuthor(Long id) {
        if(!authorRepository.existsById(id)){
            return ResponseEntity.badRequest().body("Author not found");
        }
        authorRepository.deleteById(id);
        return ResponseEntity.ok().body("Author deleted successfully");
    }
}
