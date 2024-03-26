package com.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseStatusDTO implements Serializable {
    private static final long serialVersionUID = 5590469594317747293L;

    protected String statusCode;
    protected String message;

    /**
     * set error
     *
     * @param responseStatus error code enum
     */
    public void setResponseStatus(ResponseStatus responseStatus) {
        this.statusCode = responseStatus.getStatusCode();
        this.message = responseStatus.getMessage();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
