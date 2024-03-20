package com.camunda.dto.common;

import com.camunda.enums.ErrorCodeEnum;
import com.camunda.util.ValidateUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO implements Serializable {
    private static final long serialVersionUID = 5590469594317747293L;

    protected String errorCode;
    protected String message;

    public void setError(ErrorCodeEnum errorCode) {
        if (ValidateUtil.isNotNullOrEmpty(errorCode)) {
            this.errorCode = errorCode.getErrorCode();
            this.message = errorCode.getMessage();
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
