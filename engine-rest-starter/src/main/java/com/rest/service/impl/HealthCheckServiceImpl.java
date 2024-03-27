package com.rest.service.impl;

import com.rest.config.AppConfiguration;
import com.rest.constant.Const;
import com.rest.dto.HealthCheckDTO;
import com.rest.enums.ResponseStatus;
import com.rest.service.HealthCheckService;
import com.rest.utils.ValidateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.Date;

@Service
@Slf4j
public class HealthCheckServiceImpl implements HealthCheckService {

    @Autowired
    private AppConfiguration appConfiguration;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public HealthCheckDTO getStatusSystem(boolean isDetail) {
        HealthCheckDTO healthCheckDTO = new HealthCheckDTO();
        try {
            healthCheckDTO.setHttpStatus(HttpStatus.OK);
            healthCheckDTO.setService(Const.HEALTH_CHECK_SYSTEM);
            healthCheckDTO.setStatus(Const.RUNNING);
            healthCheckDTO.setRequestTime(new Date());
            if (!isDetail) {
                return healthCheckDTO;
            }
            healthCheckDTO.setProfileActive(appConfiguration.getProfileActive());
            healthCheckDTO.setVersion(appConfiguration.getVersion());
            healthCheckDTO.setBuildDate(appConfiguration.getBuildDate());
            healthCheckDTO.setPodName(InetAddress.getLocalHost().getHostName());

        } catch (Exception ex) {
            log.error("getStatusSystem has error: ", ex);
            ResponseStatus.setServerError(healthCheckDTO);
        }
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
                healthCheckDTO.setStatus(Const.RUNNING);
            }
            healthCheckDTO.setHttpStatus(HttpStatus.OK);
        } catch (Exception ex) {
            log.error("getStatusDatabase has error: ", ex);
            ResponseStatus.setServerError(healthCheckDTO);
        }
        return healthCheckDTO;
    }

}
