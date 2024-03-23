package com.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthCheckDTO extends BaseResponse {

    private String version;
    private String status;
    private String service;
    private String profileActive;
    private String buildDate;
    private String requestTime;
    private String podName;

}
