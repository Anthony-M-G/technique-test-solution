package com.cr.app.techniquetestsolution.Controller;

import com.cr.app.techniquetestsolution.Entities.Author;
import com.cr.app.techniquetestsolution.Services.AuthorService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;


    @PostMapping("/create-author")
    public ResponseEntity<String> createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }

    @GetMapping("/get-all-authors")
    public ResponseEntity<Object> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/get-author-by-name")
    public ResponseEntity<Object> getAuthorByName(@RequestParam(required = true) @NotBlank String name,@RequestParam(required = true) @NotBlank String lastName){
        return authorService.getAuthorByName(name, lastName);
    }

    @GetMapping("/set-document-to-author")
    public ResponseEntity<Object> setDocumentToAuthor(
            @RequestParam(required = true) @NotBlank String name
            ,@RequestParam(required = true) @NotBlank  String lastName
            , Long documentId){
        return authorService.setDocumentToAuthor(name, lastName, documentId);
    }

    @DeleteMapping("/delete-author/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id){
        return authorService.deleteAuthor(id);
    }

    @PutMapping("/update-author/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable Long id, @RequestBody Author author){
        return authorService.updateAuthor(id, author);
    }
}

