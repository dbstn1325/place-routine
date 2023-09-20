package com.pr.place.domain;

import com.pr.place.exception.NoSuchPlaceCategoryException;
import org.junit.jupiter.api.Test;

import static com.pr.common.fixtures.PlaceFixtures.테스트_존재하지_않는_카테고리;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CategoryTest {

    @Test
    void 없는_카테고리를_찾을_경우_예외를_발생시킨다(){
        String category = 테스트_존재하지_않는_카테고리;

        assertThatThrownBy(()-> Category.from(category))
                .isExactlyInstanceOf(NoSuchPlaceCategoryException.class)
                .hasMessage("존재하지 않는 플레이스 카테고리 입니다.");
    }
}
