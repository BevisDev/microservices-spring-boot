package com.rest.service;

import com.rest.dto.response.BaseResponse;
import com.rest.dto.response.HealthCheckDTO;

public interface HealthCheckService {

    /**
     * health check system status
     *
     * @param isDetail want to get detail
     * @return result
     */
    BaseResponse<HealthCheckDTO> getStatusSystem(boolean isDetail);

    /**
     * health check database
     */
    BaseResponse<HealthCheckDTO> getStatusDatabase();

}
