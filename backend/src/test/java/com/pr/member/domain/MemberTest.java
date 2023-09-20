package com.pr.member.domain;

import static com.pr.common.fixtures.MemberFixtures.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.pr.member.exception.InvalidMemberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MemberTest {

    @DisplayName("회원을 생성한다.")
    @Test
    void 회원을_생성한다() {
        //given & when & then
        assertDoesNotThrow(() -> new Member(테스트_멤버_이메일, 테스트_멤버_이미지_경로, 테스트_멤버_이름, 테스트_멤버_구글_로그인_타입));
    }

    @DisplayName("회원의 email이 형식이 맞지 않으면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"dbstn6477@", "dbstn64.77.com", "dbstn6477@gmail", "@gmail.com", "dbstn6477.dbstn"})
    void 회원의_email이_형식이_맞지_않으면_예외를_던진다(final String email) {
        //given & when & then
        assertThatThrownBy(() -> new Member(email, 테스트_멤버_이미지_경로, 테스트_멤버_이름, 테스트_멤버_구글_로그인_타입))
                .isInstanceOf(InvalidMemberException.class)
                .hasMessage("이메일 형식이 올바르지 않습니다.");
    }

    @DisplayName("회원의 이름이 1 ~ 10 사이가 아닌 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "일이삼사오육칠팔구십일"})
    void 회원의_이름이_1_에서_10_사이가_아닌_경우_예외를_던진다(final String displayName) {
        //given & when & then
        assertThatThrownBy(() -> new Member(테스트_멤버_이메일, 테스트_멤버_이미지_경로, displayName, 테스트_멤버_구글_로그인_타입))
                .isInstanceOf(InvalidMemberException.class)
                .hasMessage("이름 형식이 올바르지 않습니다.");
    }
}