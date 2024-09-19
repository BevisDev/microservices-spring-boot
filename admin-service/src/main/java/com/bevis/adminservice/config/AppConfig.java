package com.bevis.adminservice.config;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfig {

    //    @Value("${application.name}")
    //    String applicationName;
    //
    //    @Value("${application.version}")
    //    String applicationVersion;
    //
    //    @Value("${build.date}")
    //    String buildDate;
    //
    //    @Value("${restTemplate.connectTimeout}")
    //    int restTemplateConnectTimeout;
    //
    //    @Value("${restTemplate.readTimeout}")
    //    int restTemplateReadTimeout;
}
