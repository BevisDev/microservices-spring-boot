package com.rest.config;

import com.rest.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestTemplateConfiguration {

    @Autowired
    private AppConfiguration appConfiguration;

    @Bean
    public RestTemplate getRestTemplate(ClientHttpRequestFactory requestFactory) {
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if (ValidateUtils.isNullOrEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new RestTemplateInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory createClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(appConfiguration.getRestTemplateConnectTimeout());
        requestFactory.setReadTimeout(appConfiguration.getRestTemplateReadTimeout());
        return new BufferingClientHttpRequestFactory(requestFactory);
    }

    public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            return null;
        }
    }
}
