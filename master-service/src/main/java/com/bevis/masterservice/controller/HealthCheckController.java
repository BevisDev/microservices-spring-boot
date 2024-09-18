package com.bevis.masterservice.controller;

import com.bevis.masterservice.dto.api.ApiResponse;
import com.bevis.masterservice.dto.healthcheck.HealthCheckResp;
import com.bevis.masterservice.service.healthcheck.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping("/healthcheck")
    public ApiResponse<HealthCheckResp> healthCheckSystem() {
        return healthCheckService.getStatusSystem();
    }

}
