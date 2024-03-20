package com.camunda.service;

import com.camunda.dto.HealthCheckDTO;

public interface HealthCheckService {

    HealthCheckDTO getStatusSystem();

    HealthCheckDTO getStatusDatabase();
    
}
