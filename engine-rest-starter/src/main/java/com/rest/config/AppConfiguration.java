package com.rest.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AppConfiguration {

    @Value("${profile.active}")
    private String profileActive;

    @Value("${pom.version}")
    private String version;

    @Value("${build.date}")
    private String buildDate;

    @Value("${restTemplate.connectTimeout}")
    private int restTemplateConnectTimeout;

    @Value("${restTemplate.readTimeout}")
    private int restTemplateReadTimeout;
}
