package com.camunda.controller;

import com.camunda.base.BaseController;
import com.camunda.consts.ApiConst;
import com.camunda.dto.HealthCheckDTO;
import com.camunda.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController extends BaseController {

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping(ApiConst.STATUS)
    public ResponseEntity<?> getStatusSystem() {
        HealthCheckDTO healthCheckDTO = new HealthCheckDTO();
        return getResult(healthCheckDTO);
    }

    @GetMapping(ApiConst.STATUS_DATABASE)
    public ResponseEntity<?> getStatusDatabase() {
        HealthCheckDTO healthCheckDTO = new HealthCheckDTO();
        return getResult(healthCheckDTO);
    }

}
