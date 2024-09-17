package com.bevis.masterservice.service.healthcheck;

import com.bevis.masterservice.dto.BaseResponse;
import com.bevis.masterservice.dto.HealthCheckResp;

public interface HealthCheckService {
    BaseResponse<HealthCheckResp> getStatusSystem();
}
