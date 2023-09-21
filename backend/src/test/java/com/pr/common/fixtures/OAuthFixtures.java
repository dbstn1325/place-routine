package com.pr.common.fixtures;

import com.pr.auth.dto.request.OAuthMember;

public enum OAuthFixtures {
    MEMBER(테스트_OAUTH_멤버());

    private OAuthMember oAuthMember;

    OAuthFixtures(final OAuthMember oAuthMember) {
        this.oAuthMember = oAuthMember;
    }

    public static final String MEMBER_OAUTH_이메일 = "yoonsu@email.com";
    public static final String MEMBER_OAUTH_이름 = "yoonsu";
    public static final String MEMBER_OAUTH_프로필 = "/yoonsu.png";
    public static final String MEMBER_OAUTH_리프레시_토큰 = "aaaaaaaaaa.bbbbbbbbbb.cccccccccc";


    public static OAuthMember 테스트_OAUTH_멤버() {
        return new OAuthMember(MEMBER_OAUTH_이메일, MEMBER_OAUTH_이름, MEMBER_OAUTH_프로필, MEMBER_OAUTH_리프레시_토큰);
    }

    public OAuthMember getOAuthMember() {
        return oAuthMember;
    };

}