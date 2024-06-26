package com.bevis.identity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bevis.identity.constant.ApiConst;
import com.bevis.identity.dto.HealthCheckResp;
import com.bevis.identity.service.health_check.IHealthCheckService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HealCheckController {

    IHealthCheckService _healthCheckService;

    @GetMapping(value = ApiConst.HEALTH_CHECK_PATH)
    public HealthCheckResp getStatusSystem(@RequestParam(value = "isDetail", required = false) boolean isDetail) {
        return _healthCheckService.getStatusSystem(isDetail);
    }

    @GetMapping(value = ApiConst.HEALTH_CHECK_DATABASE_PATH)
    public HealthCheckResp getStatusDatabase() {
        return _healthCheckService.getStatusDatabase();
    }
}
