package com.cr.app.techniquetestsolution.ControllersTest;

import com.cr.app.techniquetestsolution.Controller.AuthorController;
import com.cr.app.techniquetestsolution.Entities.Author;
import com.cr.app.techniquetestsolution.Services.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AuthorControllerTest {

    @InjectMocks
    private AuthorController authorController;

    @Mock
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAuthorReturnsExpectedResponse() {
        Author author = new Author();
        when(authorService.createAuthor(author)).thenReturn(ResponseEntity.ok("Author created"));

        ResponseEntity<String> response = authorController.createAuthor(author);

        verify(authorService, times(1)).createAuthor(author);
        assertEquals("Author created", response.getBody());
    }

    @Test
    void getAllAuthorsReturnsExpectedResponse() {
        when(authorService.getAllAuthors()).thenReturn(ResponseEntity.ok("All authors"));

        ResponseEntity<Object> response = authorController.getAllAuthors();

        verify(authorService, times(1)).getAllAuthors();
        assertEquals("All authors", response.getBody());
    }

    @Test
    void getAuthorByNameReturnsExpectedResponse() {
        when(authorService.getAuthorByName("John", "Doe")).thenReturn(ResponseEntity.ok("Author found"));

        ResponseEntity<Object> response = authorController.getAuthorByName("John", "Doe");

        verify(authorService, times(1)).getAuthorByName("John", "Doe");
        assertEquals("Author found", response.getBody());
    }

    @Test
    void setDocumentToAuthorReturnsExpectedResponse() {
        when(authorService.setDocumentToAuthor("John", "Doe", 1L)).thenReturn(ResponseEntity.ok("Document set"));

        ResponseEntity<Object> response = authorController.setDocumentToAuthor("John", "Doe", 1L);

        verify(authorService, times(1)).setDocumentToAuthor("John", "Doe", 1L);
        assertEquals("Document set", response.getBody());
    }

    @Test
    void deleteAuthorReturnsExpectedResponse() {
        when(authorService.deleteAuthor(1L)).thenReturn(ResponseEntity.ok("Author deleted"));

        ResponseEntity<String> response = authorController.deleteAuthor(1L);

        verify(authorService, times(1)).deleteAuthor(1L);
        assertEquals("Author deleted", response.getBody());
    }

    @Test
    void updateAuthorReturnsExpectedResponse() {
        Author author = new Author();
        when(authorService.updateAuthor(1L, author)).thenReturn(ResponseEntity.ok("Author updated"));

        ResponseEntity<String> response = authorController.updateAuthor(1L, author);

        verify(authorService, times(1)).updateAuthor(1L, author);
        assertEquals("Author updated", response.getBody());
    }
}