package com.bevis.fileservice.dtos.commons;

import java.util.List;
import java.util.Map;

import com.bevis.fileservice.enums.Extension;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileExportParam {
    Extension extension;
    List<String> headers;
    List<String> fieldNames;
    String fileName;
    List<?> data;
    // key 1: filedName
    // key2 ex: "true" : active,
    //          "false" : "inactive"
    Map<String, Map<String, String>> mapValues;
}
