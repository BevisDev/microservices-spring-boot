package com.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.dto.request.BaseRequest;
import com.rest.enums.DocumentType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentDTO extends BaseRequest {

    private String title;
    private DocumentType documentType;
    private String fileId;
    private List<String> attachmentIds;
    private List<String> reviewers;
    private List<String> approversLv1;
    private List<String> approversLv2;

}
