package com.camunda.service.impl;

import com.camunda.consts.Const;
import com.camunda.dto.HealthCheckDTO;
import com.camunda.service.HealthCheckService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckServiceImpl implements HealthCheckService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public HealthCheckDTO getStatusSystem() {
        HealthCheckDTO healthCheckDTO = new HealthCheckDTO();
        healthCheckDTO.setService(Const.HEALTH_CHECK_SYSTEM);
        healthCheckDTO.setStatus(Const.RUNNING);
        return healthCheckDTO;
    }

    @Override
    public HealthCheckDTO getStatusDatabase() {
        HealthCheckDTO healthCheckDTO = new HealthCheckDTO();
        healthCheckDTO.setService(Const.HEALTH_CHECK_DATABASE);
        try {
            Query query = entityManager.createQuery("SELECT 1");
            if (query.getSingleResult() != null) {
                healthCheckDTO.setStatus(Const.RUNNING);
            }
        } catch (Exception ex) {
            healthCheckDTO.setStatus(ex.getMessage());
        }
        return healthCheckDTO;
    }
}
