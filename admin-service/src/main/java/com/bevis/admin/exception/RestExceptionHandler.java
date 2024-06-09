package com.bevis.admin.exception;

import com.bevis.admin.dto.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public BaseResponse handleThrowable(Throwable ex) {
        log.error("error throwable is: ", ex);
        BaseResponse response = new BaseResponse();
        response.setServerError();
        return response;
    }

}
