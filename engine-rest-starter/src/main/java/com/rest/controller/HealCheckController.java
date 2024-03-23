package com.rest.controller;

import com.rest.constant.ApiConst;
import com.rest.dto.HealthCheckDTO;
import com.rest.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealCheckController {

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping(value = ApiConst.HEALTH_CHECK_PATH)
    public ResponseEntity<?> getStatusSystem(@RequestParam(value = "isDetail", required = false) boolean isDetail) {
        HealthCheckDTO healthCheckDTO = healthCheckService.getStatusSystem(isDetail);
        if (!healthCheckDTO.hasError()) {
            return new ResponseEntity<>(healthCheckDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(healthCheckDTO, healthCheckDTO.getHttpStatus());
    }

    @GetMapping(value = ApiConst.HEALTH_CHECK_DATABASE_PATH)
    public ResponseEntity<?> getStatusDatabase() {
        HealthCheckDTO healthCheckDTO = healthCheckService.getStatusDatabase();
        if (!healthCheckDTO.hasError()) {
            return new ResponseEntity<>(healthCheckDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(healthCheckDTO, healthCheckDTO.getHttpStatus());
    }

}
