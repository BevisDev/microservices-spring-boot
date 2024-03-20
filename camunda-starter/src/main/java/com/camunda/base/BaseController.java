package com.camunda.base;

import com.camunda.consts.ApiConst;
import com.camunda.dto.common.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiConst.API)
@Slf4j
public class BaseController {

    public <R extends ResponseDTO> ResponseEntity<?> getResult(R response) {
        if (response.hasError()) {
            log.error("response has error with errorCode: {}", response.getErrorCode());
            return new ResponseEntity<>(response, response.getHttpStatus());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
