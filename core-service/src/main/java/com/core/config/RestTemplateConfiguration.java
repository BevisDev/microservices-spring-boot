package com.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfiguration {

    @Autowired
    private AppConfiguration appConfiguration;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(appConfiguration.getRestTemplateConnectTimeout()))
                .setReadTimeout(Duration.ofMillis(appConfiguration.getRestTemplateReadTimeout()))
                .build();
    }

}
