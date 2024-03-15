package com.camunda.service.impl;

import com.camunda.constant.Const;
import com.camunda.dto.HealCheckDTO;
import com.camunda.service.HealCheckService;
import org.springframework.stereotype.Service;

@Service
public class HealCheckServiceImpl implements HealCheckService {
    @Override
    public HealCheckDTO getStatusSystem() {
        HealCheckDTO healCheckDTO = new HealCheckDTO();
        healCheckDTO.setService(Const.SYSTEM);
        healCheckDTO.setStatus(Const.RUNNING);
        return healCheckDTO;
    }

    @Override
    public HealCheckDTO getStatusDatabase() {
        return null;
    }
}
