package com.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestConfiguration {

    @Autowired
    private AppConfiguration appConfiguration;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(appConfiguration.restTemplateConnectTimeout()))
                .setReadTimeout(Duration.ofMillis(appConfiguration.restTemplateReadTimeout()))
                .build();
    }

}
