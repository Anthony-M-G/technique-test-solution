package com.cr.app.techniquetestsolution.Controller;

import com.cr.app.techniquetestsolution.Entities.DocumentEntity;
import com.cr.app.techniquetestsolution.Services.DocumentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docs")
@RequiredArgsConstructor
public class DocumentsController {
    private final DocumentService documentService;

    @PostMapping(value = "/create-doc",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createDoc(@RequestBody DocumentEntity documentEntity){
        return documentService.createDoc(documentEntity);
    }
    @GetMapping("/get-all-docs")
    public ResponseEntity<Object> getAllDocs(){
        return documentService.getAllDocs();
    }
    @GetMapping("/get-doc-by-name")
    public ResponseEntity<Object> getDocByName(@RequestParam(required = true) String title){
        return documentService.getDocByName(title);
    }
    @PutMapping("/update-doc")
    public ResponseEntity<String> updateDoc(@RequestBody DocumentEntity documentEntity){
        return documentService.updateDoc(documentEntity);
    }
    @DeleteMapping("/delete-doc/{id}")
    public ResponseEntity<String> deleteDoc(@PathVariable Long id){
        return documentService.deleteDoc(id);
    }


}
