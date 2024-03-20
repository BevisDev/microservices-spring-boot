package com.camunda.dto;

import com.camunda.dto.common.ResponseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthCheckDTO extends ResponseDTO implements Serializable {
    private static final long serialVersionUID = 6712810549790182273L;

    private String service;
    private String profile;
    private String status;
    private String version;

    @JsonProperty("request_time")
    private String requestTime;

    @JsonProperty("build_date")
    private String buildDate;
}
