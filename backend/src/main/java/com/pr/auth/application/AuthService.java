package com.pr.auth.application;

import com.pr.auth.domain.AuthToken;
import com.pr.auth.domain.OAuthToken;
import com.pr.auth.domain.OAuthTokenRepository;
import com.pr.auth.dto.request.OAuthMember;
import com.pr.auth.dto.response.AccessAndRefreshTokenResponse;
import com.pr.member.MemberRepository;
import com.pr.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;
    private final OAuthTokenRepository oAuthTokenRepository;
    private final TokenCreator tokenCreator;

    @Transactional
    public AccessAndRefreshTokenResponse generateAccessAndRefreshToken(final OAuthMember oAuthMember) {
        Member foundMember = findMember(oAuthMember);

        OAuthToken oAuthToken = getOAuthToken(oAuthMember, foundMember);
        oAuthToken.change(oAuthMember.getRefreshToken());

        AuthToken authToken = tokenCreator.createAuthToken(foundMember.getId());
        return new AccessAndRefreshTokenResponse(authToken.getAccessToken(), authToken.getRefreshToken());
    }

    private Member findMember(final OAuthMember oAuthMember) {
        String email = oAuthMember.getEmail();
        if (memberRepository.existsByEmail(email)) {
            return memberRepository.getByEmail(email);
        }

        return saveMember(oAuthMember);
    }

    private Member saveMember(final OAuthMember oAuthMember) {
        return memberRepository.save(oAuthMember.toMember());
    }

    private OAuthToken getOAuthToken(final OAuthMember oAuthMember, final Member member) {
        Long memberId = member.getId();
        if (oAuthTokenRepository.existsByMemberId(memberId)) {
            return oAuthTokenRepository.getByMemberId(memberId);
        }

        return oAuthTokenRepository.save(OAuthToken.builder()
                .member(member)
                .refreshToken(oAuthMember.getRefreshToken())
                .build());
    }

}
