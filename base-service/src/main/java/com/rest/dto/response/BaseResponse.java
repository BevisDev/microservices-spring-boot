package com.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.enums.ErrorCode;
import com.rest.utils.ValidateUtils;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -5952913922941280904L;

    private int code = 200;
    private T payload;

    private ErrorDTO error;
    private List<ErrorDTO> errors; // for many error


    public void setServerError() {
        error = new ErrorDTO();
        code = 500;
        error.setErrorCode(ErrorCode.SERVER_ERROR.getErrorCode());
        error.setMessage(ErrorCode.SERVER_ERROR.getMessage());
    }

    public void setInvalidRequest() {
        error = new ErrorDTO();
        code = 400;
        error.setErrorCode(ErrorCode.SERVER_ERROR.getErrorCode());
        error.setMessage(ErrorCode.SERVER_ERROR.getMessage());
    }

    public void setError(ErrorCode errorCode) {
        if (ValidateUtils.isNullOrEmpty(error)) {
            error = new ErrorDTO();
        }
        code = 400;
        error.setErrorCode(errorCode.getErrorCode());
        error.setMessage(errorCode.getMessage());
    }

    public boolean hasError() {
        return (ValidateUtils.isNotNullOrEmpty(error)
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