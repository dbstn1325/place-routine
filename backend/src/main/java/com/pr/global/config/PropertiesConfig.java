package com.pr.global.config;

import com.pr.global.config.properties.GoogleProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(GoogleProperties.class)
public class PropertiesConfig {
}

