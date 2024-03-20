package com.camunda.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ResponseDTO extends ErrorDTO implements Serializable {
    private static final long serialVersionUID = -5952913922941280904L;

    private Object payload;
    private List<ErrorDTO> errors; // return if it has errors

    @JsonIgnore
    private HttpStatus httpStatus;

    public boolean hasError() {
        return httpStatus != null
                && (httpStatus.is4xxClientError() || httpStatus.is5xxServerError())
                && StringUtils.isNotEmpty(errorCode)
                && StringUtils.isNotEmpty(message);
    }

}