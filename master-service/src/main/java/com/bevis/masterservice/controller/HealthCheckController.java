package com.bevis.masterservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping(value = "/healthcheck")
    public String healthCheckSystem() {
        return "Hello World!";
    }
}
