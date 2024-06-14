package com.bevis.admin.service;

import com.bevis.admin.dto.response.HealthCheckResp;

public interface IHealthCheckService {

    /**
     * health check system status
     *
     * @param isDetail want to get detail
     * @return result
     */
    HealthCheckResp getStatusSystem(boolean isDetail);

    HealthCheckResp getStatusDatabase();
}
