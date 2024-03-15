package com.rest.dto.common;

import com.rest.enums.ErrorCodeEnum;
import com.rest.utils.ValidateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = -5952913922941280904L;

    @JsonProperty("error_code")
    private String errorCode;

    private String message;

    private Object data;

    @JsonIgnore
    private HttpStatus httpStatus;

    public void setError(ErrorCodeEnum errorCode) {
        this.errorCode = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
    }

    public boolean hasError() {
        return ValidateUtils.isNotNullOrEmpty(httpStatus)
                && (httpStatus.is4xxClientError() || httpStatus.is5xxServerError())
                && StringUtils.isNotEmpty(errorCode)
                && StringUtils.isNotEmpty(message);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
