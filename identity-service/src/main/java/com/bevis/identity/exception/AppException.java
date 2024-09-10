package com.bevis.identity.exception;

import org.springframework.http.HttpStatus;

import com.bevis.identity.enums.ErrorCode;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppException extends RuntimeException {

    HttpStatus httpStatus;

    ErrorCode errorCode;

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
