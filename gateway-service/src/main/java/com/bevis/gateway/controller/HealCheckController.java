package com.bevis.gateway.controller;

import com.bevis.gateway.constant.ApiConst;
import com.bevis.gateway.service.IHealthCheckService;
import com.bevis.gateway.dto.response.HealthCheckDTO;
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

}
