package com.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.dto.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthCheckDTO extends BaseResponse {

    private String version;
    private String status;
    private String service;
    private String profileActive;
    private String buildDate;
    private Date requestTime;
    private String podName;

}
