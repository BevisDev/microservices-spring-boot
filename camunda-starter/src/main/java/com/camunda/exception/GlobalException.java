package com.camunda.exception;

import com.camunda.dto.common.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.ParseException;

@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity handleJsonProcessingException(ParseException ex) {
        log.error("handleJsonProcessingException has error: ", ex);
        ResponseDTO responseDTO = new ResponseDTO();
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ParseException.class)
    public ResponseEntity handleParseException(ParseException ex) {
        log.error("handleParseException has error: ", ex);
        ResponseDTO responseDTO = new ResponseDTO();
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ResponseDTO> handleRunTimeException(RuntimeException ex) {
        log.error("handleRunTimeException has error: ", ex);
        ResponseDTO responseDTO = new ResponseDTO();
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    public final ResponseEntity<ResponseDTO> handleThrowable(Throwable ex) {
        log.error("handleThrowable has error: ", ex);
        ResponseDTO responseDTO = new ResponseDTO();
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
    }
    
}
