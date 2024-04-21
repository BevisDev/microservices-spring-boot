package com.rest.controller;

import com.rest.dto.DocumentDTO;
import com.rest.entity.Document;
import com.rest.entity.FileDocument;
import com.rest.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    @Autowired
    private IDocumentService documentService;

    @PostMapping("/upload")
    public String create(@RequestBody DocumentDTO documentDTO) {
        Document document = new Document();
        FileDocument fileDocument = new FileDocument();
        return "OK";
    }

}
