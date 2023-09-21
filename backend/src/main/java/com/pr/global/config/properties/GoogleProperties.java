package com.pr.global.config.properties;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;


@ConfigurationProperties("oauth.google")
@ConstructorBinding
@AllArgsConstructor
@Getter
public class GoogleProperties {

    private final String clientId;
    private final String clientSecret;
    private final String endPoint;
    private final String tokenUri;
    private final List<String> scopes;
    private final String accessType;
}

