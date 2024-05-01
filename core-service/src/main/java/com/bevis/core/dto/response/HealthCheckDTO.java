package com.bevis.core.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthCheckDTO extends BaseResponse {

    private String appName;
    private String appVersion;
    private String status;
    private String service;
    private String profileActive;
    private String buildDate;
    private Date requestTime;
    private String podName;

}
