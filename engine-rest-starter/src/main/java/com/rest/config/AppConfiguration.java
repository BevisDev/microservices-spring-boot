package com.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public record AppConfiguration(@Value("${profile.active}") String profileActive,
                               @Value("${pom.version}") String version,
                               @Value("${build.date}") String buildDate,
                               @Value("${restTemplate.connectTimeout}") long restTemplateConnectTimeout,
                               @Value("${restTemplate.readTimeout}") long restTemplateReadTimeout
) {
}
