package com.pr.auth.application;


import com.pr.auth.dto.request.OAuthMember;

public interface OAuthClient {
    OAuthMember getOAuthMember(final String code);
}
