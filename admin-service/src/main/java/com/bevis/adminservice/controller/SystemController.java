package com.bevis.adminservice.controller;

import com.bevis.masterservice.controller.HealthCheckController;
import org.springframework.web.bind.annotation.RestController;

/**
 * path inherit parent
 * health check system: /healthcheck
 */
@RestController
public class SystemController extends HealthCheckController {
}
