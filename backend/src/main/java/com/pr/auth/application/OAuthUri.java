package com.pr.auth.application;

@FunctionalInterface
public interface OAuthUri {

    String generate(final String redirectUri);
}

