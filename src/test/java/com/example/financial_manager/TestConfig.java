package com.example.financial_manager;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@TestConfiguration
public class TestConfig {

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {

        return new RestTemplateBuilder()
                .basicAuthentication("user", "password")
                .setConnectTimeout(Duration.ofSeconds(5));
    }
}
