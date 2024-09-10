package com.bevis.identity.service.health_check;

import com.bevis.identity.dto.HealthCheckResp;

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
