package com.core.service;

import com.core.config.AppConfiguration;
import com.core.constant.Const;
import com.core.dto.response.HealthCheckDTO;
import com.core.utils.ValidateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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

    @PersistenceContext
    private EntityManager entityManager;

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
        } catch (Exception e) {
            log.error("cannot get hostname: ", e);
        }
        healthCheckDTO.setSuccess(true);
        return healthCheckDTO;
    }

    @Override
    public HealthCheckDTO getStatusDatabase() {
        HealthCheckDTO healthCheckDTO = new HealthCheckDTO();
        try {
            healthCheckDTO.setService(Const.HEALTH_CHECK_MYSQL_DATABASE);
            healthCheckDTO.setRequestTime(new Date());
            Query query = entityManager.createQuery("SELECT 1");
            if (ValidateUtils.isNotNullOrEmpty(query.getSingleResult())) {
                healthCheckDTO.setSuccess(true);
                healthCheckDTO.setStatus(Const.RUNNING);
            } else {
                healthCheckDTO.setSuccess(false);
            }
        } catch (Exception ex) {
            log.error("getStatusDatabase has error: ", ex);
            healthCheckDTO.setServerError();
        }
        return healthCheckDTO;
    }
}
