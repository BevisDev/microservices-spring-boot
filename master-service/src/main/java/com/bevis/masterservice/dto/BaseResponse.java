package com.bevis.masterservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -5952913922941280904L;

    boolean success = true;
    Date responseAt;
    String requestId;
    T data;
    List<Error> errors;

    public static class Error {
        String errorCode;
        String message;
    }

}
