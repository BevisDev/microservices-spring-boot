package com.bevis.identity.dto.api;

import java.io.Serial;
import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.bevis.identity.enums.ErrorCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -5952913922941280904L;

    @Builder.Default
    boolean success = true;

    ErrorDTO error;
    T result;

    @Builder
    public ApiResponse(T result) {
        this.result = result;
    }

    public void setErrorResp(ErrorCode errorCode) {
        this.success = false;
        this.error = new ErrorDTO();
        this.error.setErrorCode(errorCode.getErrorCode());
        this.error.setMessage(errorCode.getMessage());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ErrorDTO {

        String errorCode;
        String message;

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        }
    }
}
