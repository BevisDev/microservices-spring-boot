package com.bevis.identity.service.health_check;

import java.net.InetAddress;
import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Service;

import com.bevis.identity.config.AppConfiguration;
import com.bevis.identity.constant.Const;
import com.bevis.identity.dto.HealthCheckResp;
import com.bevis.identity.exception.AppException;
import com.bevis.identity.utils.ValidateUtils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HealthCheckService implements IHealthCheckService {

    AppConfiguration _appConfiguration;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public HealthCheckResp getStatusSystem(boolean isDetail) {
        HealthCheckResp healthCheckResp = new HealthCheckResp();
        healthCheckResp.setService(Const.HEALTH_CHECK_SYSTEM);
        healthCheckResp.setStatus(Const.RUNNING);
        healthCheckResp.setRequestTime(new Date());
        if (!isDetail) {
            return healthCheckResp;
        }
        healthCheckResp.setAppName(_appConfiguration.getAppName());
        healthCheckResp.setAppVersion(_appConfiguration.getAppVersion());
        healthCheckResp.setBuildDate(_appConfiguration.getBuildDate());
        try {
            healthCheckResp.setPodName(InetAddress.getLocalHost().getHostName());
        } catch (Exception e) {
            log.error("cannot get hostname: ", e);
        }
        return healthCheckResp;
    }

    @Override
    public HealthCheckResp getStatusDatabase() {
        HealthCheckResp healthCheckResp = new HealthCheckResp();
        try {
            healthCheckResp.setService(Const.HEALTH_CHECK_MYSQL_DATABASE);
            healthCheckResp.setRequestTime(new Date());
            Query query = entityManager.createQuery("SELECT 1");
            if (ValidateUtils.isNotNullOrEmpty(query.getSingleResult())) {
                healthCheckResp.setStatus(Const.RUNNING);
            }
        } catch (Exception ex) {
            log.error("getStatusDatabase has error: ", ex);
            throw new AppException("Connect database has error.");
        }
        return healthCheckResp;
    }
}
