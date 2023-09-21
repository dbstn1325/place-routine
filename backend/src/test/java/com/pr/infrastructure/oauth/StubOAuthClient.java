package com.pr.infrastructure.oauth;


import com.pr.auth.application.OAuthClient;
import com.pr.auth.dto.request.OAuthMember;
import com.pr.common.fixtures.OAuthFixtures;

public class StubOAuthClient implements OAuthClient {

    @Override
    public OAuthMember getOAuthMember(final String code) {
        return OAuthFixtures.MEMBER.getOAuthMember();
    }
}
