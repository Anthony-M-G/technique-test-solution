package com.cr.app.techniquetestsolution.Services.ServicesImpl;

import com.cr.app.techniquetestsolution.Entities.Author;
import com.cr.app.techniquetestsolution.Entities.DocumentEntity;
import com.cr.app.techniquetestsolution.Repository.AuthorRepository;
import com.cr.app.techniquetestsolution.Repository.DocumentRepository;
import com.cr.app.techniquetestsolution.Services.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentServiceImpl implements DocumentService {
    private final AuthorRepository authorRepository;
    private final DocumentRepository documentRepository;
    @Override
    public ResponseEntity<Object> getAllDocs() {
        return ResponseEntity.accepted().body(documentRepository.findAll());
    }

    @Override
    public ResponseEntity<Object> getDocByName(String name) {
        DocumentEntity documentEntity = documentRepository.findByTitle(name);
        if(documentEntity == null){
            return ResponseEntity.badRequest().body("Document not found");
        }
        return ResponseEntity.accepted().body(documentEntity);
    }

    @Override
    public ResponseEntity<String> updateDoc(DocumentEntity documentEntity) {
        if(!documentRepository.existsByTitle(documentEntity.getTitle())){
            return ResponseEntity.badRequest().body("Documento no encontrado");
        }
        DocumentEntity update=documentRepository.findByTitle(documentEntity.getTitle());
        update.setTitle(documentEntity.getTitle());
        update.setBody(documentEntity.getBody());
        update.setAuthors(this.verifyExistOrNotAuthor(documentEntity.getAuthors()));
        return ResponseEntity.ok().body("Actualizado con éxito");
    }

    @Override
    public ResponseEntity<String> deleteDoc(Long id) {
        if(!documentRepository.existsById(id)){
            return ResponseEntity.badRequest().body("El documento no existe");
        }
        return ResponseEntity.ok("El documento fue eliminado");
    }

    @Override
    public ResponseEntity<String> createDoc(DocumentEntity documentEntity) {
        if (documentEntity.getAuthors().isEmpty()) {
            return ResponseEntity.badRequest().body("Authors cannot be empty");
        } else if (documentRepository.existsByTitle(documentEntity.getTitle())) {
            return ResponseEntity.badRequest().body("Document already exists");
        }

        DocumentEntity documentEntity1 = new DocumentEntity().builder()
                .title(documentEntity.getTitle())
                .body(documentEntity.getBody())
                .authors(this.verifyExistOrNotAuthor(documentEntity.getAuthors()))
                .build();
        documentRepository.save(documentEntity);
        return ResponseEntity.ok("Document created successfully");
    }



    @Override
    public Set<Author> verifyExistOrNotAuthor(Set<Author> authors){
        authors.stream().map(author -> {
            if (!authorRepository.existsAuthorByFirstNameAndLastName(author.getFirstName(), author.getLastName())) {
                return new Author().builder()
                        .firstName(author.getFirstName())
                        .lastName(author.getLastName())
                        .build();
            }
            Author authorBD = authorRepository.getAuthorByFirstName(author.getFirstName());
            return Author.builder().
                    firstName(authorBD.getFirstName())
                    .lastName(authorBD.getLastName())
                    .build();
        }).collect(Collectors.toSet());
        return authors;
    }
}
