package com.pr.category;

import com.pr.category.domain.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @DisplayName("카테고리를 생성한다.")
    @Test
    void 카테고리를_생성한다() {
        // given
        String name = "조깅";

        // when & then
        assertDoesNotThrow(() -> new Category(name));
    }

    @DisplayName("카테고리 이름이 공백인 경우 예외를 던진다.")
    @Test
    void 카테고리_이름이_공백인_경우_예외를_던진다() {
        // given
        String name = "";

        // when & then
        assertThatThrownBy(() -> new Category(name))
                .isInstanceOf(InvalidCategoryException.class);
    }
}