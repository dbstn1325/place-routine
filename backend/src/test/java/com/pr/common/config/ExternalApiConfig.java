package com.pr.common.config;

import com.pr.auth.application.OAuthClient;
import com.pr.infrastructure.oauth.StubOAuthClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ExternalApiConfig {

    @Bean
    public OAuthClient oAuthClient() {
        return new StubOAuthClient();
    }
}