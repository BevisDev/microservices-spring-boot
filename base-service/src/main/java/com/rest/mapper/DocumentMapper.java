package com.rest.mapper;

import com.rest.dto.DocumentDTO;
import com.rest.entity.Document;
import org.springframework.stereotype.Service;

@Service
public class DocumentMapper implements IDocumentMapper {

    public Document fromDTO(DocumentDTO dto) {
        Document document = new Document();
        return document;
    }
}
