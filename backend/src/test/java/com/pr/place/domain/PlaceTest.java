package com.pr.place.domain;

import com.pr.category.domain.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.pr.common.fixtures.CategoryFixtures.테스트_카테고리;
import static com.pr.common.fixtures.PlaceFixtures.테스트_플레이스;
import static org.junit.jupiter.api.Assertions.*;


class PlaceTest {

    @DisplayName("플레이스를 생성한다.")
    @Test
    void 플레이스를_생성한다() {
        //given & when & then
        assertDoesNotThrow(() -> 테스트_플레이스(테스트_카테고리()));
    }
}