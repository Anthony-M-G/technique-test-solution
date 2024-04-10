package com.cr.app.techniquetestsolution.ControllersTest;


import com.cr.app.techniquetestsolution.Controller.DocumentsController;
import com.cr.app.techniquetestsolution.Entities.DocumentEntity;
import com.cr.app.techniquetestsolution.Services.DocumentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DocumentsControllerTest {

    @InjectMocks
    private DocumentsController documentsController;

    @Mock
    private DocumentService documentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDocReturnsExpectedResponse() {
        DocumentEntity documentEntity = new DocumentEntity();
        when(documentService.createDoc(documentEntity)).thenReturn(ResponseEntity.ok("Document created"));

        ResponseEntity<String> response = documentsController.createDoc(documentEntity);

        verify(documentService, times(1)).createDoc(documentEntity);
        assertEquals("Document created", response.getBody());
    }

    @Test
    void getAllDocsReturnsExpectedResponse() {
        when(documentService.getAllDocs()).thenReturn(ResponseEntity.ok("All documents"));

        ResponseEntity<Object> response = documentsController.getAllDocs();

        verify(documentService, times(1)).getAllDocs();
        assertEquals("All documents", response.getBody());
    }

    @Test
    void getDocByNameReturnsExpectedResponse() {
        when(documentService.getDocByName("Title")).thenReturn(ResponseEntity.ok("Document found"));

        ResponseEntity<Object> response = documentsController.getDocByName("Title");

        verify(documentService, times(1)).getDocByName("Title");
        assertEquals("Document found", response.getBody());
    }

    @Test
    void updateDocReturnsExpectedResponse() {
        DocumentEntity documentEntity = new DocumentEntity();
        when(documentService.updateDoc(documentEntity)).thenReturn(ResponseEntity.ok("Document updated"));

        ResponseEntity<String> response = documentsController.updateDoc(documentEntity);

        verify(documentService, times(1)).updateDoc(documentEntity);
        assertEquals("Document updated", response.getBody());
    }

    @Test
    void deleteDocReturnsExpectedResponse() {
        when(documentService.deleteDoc(1L)).thenReturn(ResponseEntity.ok("Document deleted"));

        ResponseEntity<String> response = documentsController.deleteDoc(1L);

        verify(documentService, times(1)).deleteDoc(1L);
        assertEquals("Document deleted", response.getBody());
    }
}

