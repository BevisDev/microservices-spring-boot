package com.bevis.adminservice.controller;

import com.bevis.masterservice.controller.HealthCheckController;
import com.bevis.masterservice.service.healthcheck.HealthCheckService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController extends HealthCheckController {

    public SystemController(HealthCheckService healthCheckService) {
        super(healthCheckService);
    }

    /**
     * path inherit
     * /healthcheck => health check system
     */
}
