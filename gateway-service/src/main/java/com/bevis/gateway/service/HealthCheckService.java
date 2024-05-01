package com.bevis.gateway.service;

import com.bevis.gateway.config.AppConfiguration;
import com.bevis.gateway.constant.Const;
import com.bevis.gateway.dto.response.HealthCheckDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.Date;

@Service
@Slf4j
public class HealthCheckService implements IHealthCheckService {

    @Autowired
    private AppConfiguration appConfiguration;

    @Override
    public HealthCheckDTO getStatusSystem(boolean isDetail) {
        HealthCheckDTO healthCheckDTO = new HealthCheckDTO();
        healthCheckDTO.setService(Const.HEALTH_CHECK_SYSTEM);
        healthCheckDTO.setStatus(Const.RUNNING);
        healthCheckDTO.setRequestTime(new Date());
        if (!isDetail) {
            return healthCheckDTO;
        }
        healthCheckDTO.setProfileActive(appConfiguration.getProfileActive());
        healthCheckDTO.setAppName(appConfiguration.getAppName());
        healthCheckDTO.setAppVersion(appConfiguration.getAppVersion());
        healthCheckDTO.setBuildDate(appConfiguration.getBuildDate());
        try {
            healthCheckDTO.setPodName(InetAddress.getLocalHost().getHostName());
        } catch (Exception ex) {
            log.error("cannot get hostname: ", ex);
        }
        healthCheckDTO.setSuccess(true);
        return healthCheckDTO;
    }

}
