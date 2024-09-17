package com.bevis.masterservice.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class HealthCheckResp implements Serializable {
    @Serial
    private static final long serialVersionUID = -5365683055652186372L;

    String appName;
    String appVersion;
    String buildTime;
    String service;
    String status;
    Date requestTime;
}
