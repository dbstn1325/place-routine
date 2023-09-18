package com.pr.place.domain;

import com.pr.category.domain.Category;
import com.pr.place.exception.InvalidPlaceException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.pr.common.fixtures.CategoryFixtures.테스트_카테고리;
import static com.pr.common.fixtures.PlaceFixtures.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class PlaceTest {

    @DisplayName("플레이스를 생성한다.")
    @Test
    void 플레이스를_생성한다() {
        //given & when & then
        assertDoesNotThrow(() -> 테스트_플레이스(테스트_카테고리()));
    }


    @DisplayName("플레이스 메모의 길이가 255를 초과하는 경우 예외를 던진다.")
    @Test
    void 일정_메모의_길이가_255를_초과하는_경우_예외를_던진다() {
        // given
        Category 테스트_카테고리 = 테스트_카테고리();
        String memo = "1".repeat(256);

        // when & then
        assertThatThrownBy(() -> new Place(테스트_카테고리, 테스트_플레이스_명, 테스트_플레이스_오픈_시간, 테스트_플레이스_마감_시간, 테스트_플레이스_위치, memo, 테스트_포인트))
                .isInstanceOf(InvalidPlaceException.class);
    }
}