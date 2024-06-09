package com.bevis.admin.service;

import com.bevis.admin.dto.response.HealthCheckDTO;

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
