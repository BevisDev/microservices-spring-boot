package com.bevis.admin.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AppConfiguration {

    @Value("${profile.active}")
    private String profileActive;

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${build.date}")
    private String buildDate;

    @Value("${restTemplate.connectTimeout}")
    private int restTemplateConnectTimeout;

    @Value("${restTemplate.readTimeout}")
    private int restTemplateReadTimeout;
}
