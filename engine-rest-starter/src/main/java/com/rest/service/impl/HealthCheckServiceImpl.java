package com.rest.service.impl;

import com.rest.config.AppConfiguration;
import com.rest.constant.Const;
import com.rest.dto.response.BaseResponse;
import com.rest.dto.response.HealthCheckDTO;
import com.rest.service.HealthCheckService;
import com.rest.utils.ValidateUtils;
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
public class HealthCheckServiceImpl implements HealthCheckService {

    @Autowired
    private AppConfiguration appConfiguration;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BaseResponse<HealthCheckDTO> getStatusSystem(boolean isDetail) {
        BaseResponse<HealthCheckDTO> response = new BaseResponse<>();
        HealthCheckDTO healthCheckDTO = new HealthCheckDTO();
        try {
            healthCheckDTO.setService(Const.HEALTH_CHECK_SYSTEM);
            healthCheckDTO.setStatus(Const.RUNNING);
            healthCheckDTO.setRequestTime(new Date());
            if (!isDetail) {
                response.setPayload(healthCheckDTO);
                return response;
            }
            healthCheckDTO.setProfileActive(appConfiguration.getProfileActive());
            healthCheckDTO.setVersion(appConfiguration.getVersion());
            healthCheckDTO.setBuildDate(appConfiguration.getBuildDate());
            healthCheckDTO.setPodName(InetAddress.getLocalHost().getHostName());
            response.setPayload(healthCheckDTO);
        } catch (Exception ex) {
            log.error("getStatusSystem has error: ", ex);
            response.setServerError();
        }
        return response;
    }

    @Override
    public BaseResponse<HealthCheckDTO> getStatusDatabase() {
        BaseResponse<HealthCheckDTO> response = new BaseResponse<>();
        HealthCheckDTO healthCheckDTO = new HealthCheckDTO();
        try {
            healthCheckDTO.setService(Const.HEALTH_CHECK_MYSQL_DATABASE);
            healthCheckDTO.setRequestTime(new Date());
            Query query = entityManager.createQuery("SELECT 1");
            if (ValidateUtils.isNotNullOrEmpty(query.getSingleResult())) {
                healthCheckDTO.setStatus(Const.RUNNING);
                response.setPayload(healthCheckDTO);
            }
        } catch (Exception ex) {
            log.error("getStatusDatabase has error: ", ex);
            response.setServerError();
        }
        return response;
    }

}
