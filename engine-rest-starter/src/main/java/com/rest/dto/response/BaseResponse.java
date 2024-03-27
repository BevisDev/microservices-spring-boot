package com.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.enums.ResponseStatus;
import com.rest.utils.ValidateUtils;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T> extends ResponseStatusDTO implements Serializable {
    private static final long serialVersionUID = -5952913922941280904L;

    private T payload;
    private List<ResponseStatusDTO> errors; // return if it has errors

    @JsonIgnore
    private HttpStatus httpStatus;

    /**
     * add errors
     *
     * @param responseStatus error code
     */
    public void addResponseStatus(ResponseStatus responseStatus) {
        ResponseStatusDTO respStatus = new ResponseStatusDTO();
        respStatus.setResponseStatus(responseStatus);
        if (ValidateUtils.isNullOrEmpty(this.errors)) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(respStatus);
    }

    /**
     * check response if it has error
     *
     * @return
     */
    public boolean hasError() {
        return httpStatus != null
                && (httpStatus.is4xxClientError() || httpStatus.is5xxServerError())
                && StringUtils.isNotEmpty(statusCode)
                && StringUtils.isNotEmpty(message);
    }

}