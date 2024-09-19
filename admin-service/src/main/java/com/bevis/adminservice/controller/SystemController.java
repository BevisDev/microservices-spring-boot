package com.bevis.adminservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bevis.masterservice.controller.HealthCheckController;

/**
 * path inherit parent
 * health check system: /healthcheck
 */
@RestController
public class SystemController extends HealthCheckController {}
