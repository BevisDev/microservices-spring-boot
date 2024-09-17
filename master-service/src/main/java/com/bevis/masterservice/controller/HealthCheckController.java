package com.bevis.masterservice.controller;

import com.bevis.masterservice.dto.BaseResponse;
import com.bevis.masterservice.dto.HealthCheckResp;
import com.bevis.masterservice.service.healthcheck.HealthCheckService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HealthCheckController {

    HealthCheckService healthCheckService;

    @GetMapping("/healthcheck")
    public BaseResponse<HealthCheckResp> healthCheckSystem() {
        return healthCheckService.getStatusSystem();
    }

}
