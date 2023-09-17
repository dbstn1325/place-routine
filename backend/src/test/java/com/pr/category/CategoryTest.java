package com.pr.category;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}