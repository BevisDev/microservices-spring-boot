package com.rest.controller;

import com.rest.constant.ApiConst;
import com.rest.dto.response.BaseResponse;
import com.rest.dto.response.HealthCheckDTO;
import com.rest.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealCheckController {

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping(value = ApiConst.HEALTH_CHECK_PATH)
    public BaseResponse<HealthCheckDTO> getStatusSystem(@RequestParam(value = "isDetail", required = false) boolean isDetail) {
        BaseResponse<HealthCheckDTO> response = healthCheckService.getStatusSystem(isDetail);
        return response;
    }

    @GetMapping(value = ApiConst.HEALTH_CHECK_DATABASE_PATH)
    public BaseResponse<?> getStatusDatabase() {
        BaseResponse<HealthCheckDTO> response = healthCheckService.getStatusDatabase();
        return response;
    }

}
