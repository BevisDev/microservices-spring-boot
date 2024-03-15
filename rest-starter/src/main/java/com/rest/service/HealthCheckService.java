package com.rest.service;

import com.rest.dto.HealthCheckDTO;

public interface HealthCheckService {

    /**
     * health check system status
     *
     * @param isDetail want to get detail
     * @return result
     */
    HealthCheckDTO getStatusSystem(boolean isDetail);
//
//    /**
//     * health check database
//     */
//    HealthCheckDTO getStatusDatabase();

}
