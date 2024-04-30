package com.core.controller;

import com.core.constant.ApiConst;
import com.core.dto.response.HealthCheckDTO;
import com.core.service.IHealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealCheckController {

    @Autowired
    private IHealthCheckService healthCheckService;

    @GetMapping(value = ApiConst.HEALTH_CHECK_PATH)
    public HealthCheckDTO getStatusSystem(
            @RequestParam(value = "isDetail", required = false) boolean isDetail) {
        return healthCheckService.getStatusSystem(isDetail);
    }

    @GetMapping(value = ApiConst.HEALTH_CHECK_DATABASE_PATH)
    public HealthCheckDTO getStatusDatabase() {
        return healthCheckService.getStatusDatabase();
    }
}
