package com.bevis.masterservice.service.healthcheck;

import com.bevis.masterservice.config.healthcheck.HealthCheckProps;
import com.bevis.masterservice.consts.Const;
import com.bevis.masterservice.dto.BaseResponse;
import com.bevis.masterservice.dto.HealthCheckResp;
import com.bevis.masterservice.enums.StatusEnum;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HealthCheckServiceImpl implements HealthCheckService {

    HealthCheckProps healthCheckProps;

    @Override
    public BaseResponse<HealthCheckResp> getStatusSystem() {
        HealthCheckResp healthCheckResp = HealthCheckResp.builder()
                .appName(healthCheckProps.getName())
                .appVersion(healthCheckProps.getVersion())
                .buildTime(healthCheckProps.getBuildTime())
                .status(StatusEnum.SUCCESS.getCapitalValue())
                .service(Const.HEALTH_CHECK_SYSTEM)
                .requestTime(new Date())
                .build();
        return new BaseResponse<>(healthCheckResp);
    }
}

