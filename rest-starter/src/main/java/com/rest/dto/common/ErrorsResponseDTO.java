package com.rest.dto.common;

import com.rest.enums.ErrorCodeEnum;
import com.rest.utils.ValidateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ErrorsResponseDTO implements Serializable {

    private static final long serialVersionUID = -5952913922941280904L;

    private List<ResponseDTO> errors;

    @JsonIgnore
    private HttpStatus httpStatus;

    /**
     * add each error for response
     *
     * @param errorCode
     */
    public void addError(ErrorCodeEnum errorCode) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setError(errorCode);
        if (ValidateUtils.isNullOrEmpty(this.errors)) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(responseDTO);
    }

    /**
     * add errors
     *
     * @param errors
     */
    public void addErrors(List<ErrorCodeEnum> errors) {
        if (ValidateUtils.isNotNullOrEmpty(errors)) {
            errors.forEach(error -> {
                ResponseDTO responseDTO = new ResponseDTO();
                responseDTO.setError(error);
                if (ValidateUtils.isNullOrEmpty(this.errors)) {
                    this.errors = new ArrayList<>();
                }
                this.errors.add(responseDTO);
            });
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
