package com.bevis.masterservice.config.healthcheck;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@ConfigurationProperties(prefix = "healthcheck.application")
public class HealthCheckProps implements Serializable {
    @Serial
    private static final long serialVersionUID = -2317843307970837473L;

    String name;
    String version;
    String buildTime;
}
