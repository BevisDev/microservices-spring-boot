package com.rest.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.dto.ErrorDTO;
import com.rest.enums.ErrorCodeEnum;
import com.rest.utils.ValidateUtils;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class BaseResponse extends ErrorDTO implements Serializable {
    private static final long serialVersionUID = -5952913922941280904L;

    private Object payload;
    private List<ErrorDTO> errors; // return if it has errors

    @JsonIgnore
    private HttpStatus httpStatus;

    /**
     * add errors
     *
     * @param errorCode error code
     */
    public void addErrors(ErrorCodeEnum errorCode) {
        ErrorDTO error = new ErrorDTO();
        error.setError(errorCode);
        if (ValidateUtils.isNullOrEmpty(this.errors)) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(error);
    }

    /**
     * check response if it has error
     * @return
     */
    public boolean hasError() {
        return httpStatus != null
                && (httpStatus.is4xxClientError() || httpStatus.is5xxServerError())
                && StringUtils.isNotEmpty(errorCode)
                && StringUtils.isNotEmpty(message);
    }

}