package com.pr.place.domain;

import com.pr.place.exception.InvalidPlaceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.pr.common.fixtures.PlaceFixtures.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class PlaceTest {

    @DisplayName("플레이스를 생성한다.")
    @Test
    void 플레이스를_생성한다() {
        //given & when & then
        assertDoesNotThrow(() -> 테스트_플레이스());
    }


    @DisplayName("플레이스 메모의 길이가 255를 초과하는 경우 예외를 던진다.")
    @Test
    void 플레이스_메모의_길이가_255를_초과하는_경우_예외를_던진다() {
        // given
        String memo = "1".repeat(256);

        // when & then
        assertThatThrownBy(() -> new Place(테스트_코딩_카테고리, 테스트_플레이스_명, 테스트_플레이스_오픈_시간, 테스트_플레이스_마감_시간, 테스트_플레이스_위치, memo, 테스트_포인트))
                .isInstanceOf(InvalidPlaceException.class);
    }

    @DisplayName("플레이스 제목의 길이가 50을 초과하는 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"일이삼사오육칠팔구십일이삼사오육칠팔구십일일이삼사오육칠팔구십일이삼사오육칠팔구십일일이삼사오육칠팔구십일",
            "플레이스 루틴 플레이스 루틴 플레이스 루틴 플레이스 루틴 플레이스 루틴 플레이스 루틴 플레이스 루틴 플레이스 루틴 플레이스 루틴"})
    void 플레이스_제목의_길이가_50을_초과하는_경우_예외를_던진다(final String 잘못된_일정_제목) {
        // given & when & then
        assertThatThrownBy(() -> new Place(테스트_코딩_카테고리, 잘못된_일정_제목, 테스트_플레이스_오픈_시간, 테스트_플레이스_마감_시간, 테스트_플레이스_위치, 테스트_메모, 테스트_포인트))
                .isInstanceOf(InvalidPlaceException.class);
    }
}