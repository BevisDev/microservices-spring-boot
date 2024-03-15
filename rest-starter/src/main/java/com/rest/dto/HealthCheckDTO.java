package com.rest.dto;

import com.rest.dto.common.ResponseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class HealthCheckDTO extends ResponseDTO implements Serializable {

    private static final long serialVersionUID = -8105285939106329337L;

    private String version;
    private String status;
    private String service;

    @JsonProperty("active_profile")
    private String activeProfile;

    @JsonProperty("build_date")
    private String buildDate;

    @JsonProperty("request_time")
    private String requestTime;

    @JsonProperty("pod_name")
    private String podName;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
