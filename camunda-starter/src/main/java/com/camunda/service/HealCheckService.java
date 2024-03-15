package com.camunda.service;

import com.camunda.dto.HealCheckDTO;

public interface HealCheckService {

    HealCheckDTO getStatusSystem();

    HealCheckDTO getStatusDatabase();
}
