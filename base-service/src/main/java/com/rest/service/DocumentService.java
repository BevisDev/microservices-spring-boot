package com.rest.service;

import com.rest.dto.DocumentDTO;
import com.rest.entity.Document;
import com.rest.entity.FileDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class DocumentService implements IDocumentService {


    public void create(DocumentDTO dto) {
        Document document = new Document();
        document.setTitle(dto.getTitle());
        document.setType(dto.getDocumentType());

        FileDocument fileDocument;
    }
}
