package com.bevis.identity.exception;

import com.bevis.identity.dto.api.ApiResponse;
import com.bevis.identity.enums.ErrorCode;
import com.bevis.identity.utils.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Throwable.class, RuntimeException.class})
    public ResponseEntity<?> handleThrowable(Throwable ex) {
        log.error("error throwable is: ", ex);
        ApiResponse<?> response = new ApiResponse<>();
        response.setErrorResp(ErrorCode.SERVER_ERROR);
        return ResponseEntity.internalServerError().body(response);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> handleAppException(AppException ex) {
        log.error("error app is: ", ex);
        ApiResponse<?> response = new ApiResponse<>();
        HttpStatus httpStatus = ValidateUtils.isNotNullOrEmpty(ex.getHttpStatus())
                ? ex.getHttpStatus()
                : HttpStatus.INTERNAL_SERVER_ERROR;
        if (ValidateUtils.isNotNullOrEmpty(ex.getErrorCode())) {
            response.setErrorResp(ErrorCode.SERVER_ERROR);
        } else {
            ApiResponse.ErrorDTO error = new ApiResponse.ErrorDTO();
            error.setMessage(ex.getMessage());
            response.setError(error);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @ExceptionHandler(
            value = {
                    MissingServletRequestParameterException.class,
                    HttpMessageNotReadableException.class,
                    IllegalArgumentException.class,
                    MethodArgumentTypeMismatchException.class
            })
    public ResponseEntity<?> handleInvalidRequest(Exception exception) {
        log.error("error invalid request: ", exception);
        ApiResponse<?> response = new ApiResponse<>();
        response.setErrorResp(ErrorCode.INVALID_REQUEST);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = {NoResourceFoundException.class, NoHandlerFoundException.class})
    public ResponseEntity<?> handleNotFound(Exception exception) {
        log.error("error not found: ", exception);
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleMethodNotSupportedException(Exception ex) {
        log.error("error method not supported: ", ex);
        ApiResponse<?> response = new ApiResponse<>();
        response.setErrorResp(ErrorCode.METHOD_NOT_ALLOW);
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
