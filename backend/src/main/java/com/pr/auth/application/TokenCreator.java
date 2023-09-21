package com.pr.auth.application;


import com.pr.auth.domain.AuthToken;

public interface TokenCreator {

    AuthToken createAuthToken(final Long memberId);
}
