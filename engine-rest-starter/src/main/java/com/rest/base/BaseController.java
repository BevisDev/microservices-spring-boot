package com.rest.base;

import com.rest.constant.ApiConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiConst.API)
@Slf4j
public class BaseController {

//    public <R extends BaseResponse> ResponseEntity<?> getResult(R response) {
//        if (response.hasError()) {
//            log.error("response has error with errorCode: {}", response.getErrorCode());
//            return new ResponseEntity<>(response, response.getHttpStatus());
//        }
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

}
