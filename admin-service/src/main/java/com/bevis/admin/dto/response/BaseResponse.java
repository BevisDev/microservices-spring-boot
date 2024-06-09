package com.bevis.admin.dto.response;

import com.bevis.admin.enums.ResponseCode;
import com.bevis.admin.utils.ValidateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -5952913922941280904L;

    private Boolean success;
    private String code;
    private String message;
    private ErrorDTO error;
    private List<ErrorDTO> errors; // for many error

    @JsonIgnore
    private HttpStatus httpStatus;

    public void setServerError() {
        success = false;
        error = new ErrorDTO();
        error.setErrorCode(ResponseCode.SERVER_ERROR.getCode());
        error.setMessage(ResponseCode.SERVER_ERROR.getMessage());
    }

    public void setInvalidRequest() {
        error = new ErrorDTO();
        success = false;
        error.setErrorCode(ResponseCode.SERVER_ERROR.getCode());
        error.setMessage(ResponseCode.SERVER_ERROR.getMessage());
    }

    public void setSuccessful(ResponseCode responseCode) {
        success = true;
        message = responseCode.getMessage();
        code = responseCode.getCode();
    }

    public void setFail(ResponseCode responseCode) {
        error = new ErrorDTO();
        error.setErrorCode(responseCode.getCode());
        error.setMessage(responseCode.getMessage());
    }

    public boolean hasError() {
        return (ValidateUtils.isNotNullOrEmpty(httpStatus)
                && httpStatus.is4xxClientError() || httpStatus.is5xxServerError())
                || (ValidateUtils.isNotNullOrEmpty(error)
                && ValidateUtils.isNotNullOrEmpty(error.getErrorCode())
                && ValidateUtils.isNotNullOrEmpty(error.getMessage()))
                || ValidateUtils.isNotNullOrEmpty(errors);
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ErrorDTO implements Serializable {
        @Serial
        private static final long serialVersionUID = -265556818775817283L;

        private String errorCode;
        private String message;

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        }
    }
}