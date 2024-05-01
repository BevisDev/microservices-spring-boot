package com.bevis.gateway.service;

import com.bevis.gateway.dto.response.HealthCheckDTO;

public interface IHealthCheckService {

    /**
     * health check system status
     *
     * @param isDetail want to get detail
     * @return result
     */
    HealthCheckDTO getStatusSystem(boolean isDetail);
}
