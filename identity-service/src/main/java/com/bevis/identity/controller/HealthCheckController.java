package com.bevis.identity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    @GetMapping("/health-check")
    public ResponseEntity<?> getStatus() {
        Map<String, String> map = new HashMap<>();
        map.put("service", "system");
        map.put("status", "Ok");
        return ResponseEntity.ok(map);
    }

}
