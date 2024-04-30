package com.core.service;

import com.core.dto.response.HealthCheckDTO;

public interface IHealthCheckService {

    /**
     * health check system status
     *
     * @param isDetail want to get detail
     * @return result
     */
    HealthCheckDTO getStatusSystem(boolean isDetail);

    HealthCheckDTO getStatusDatabase();
}
