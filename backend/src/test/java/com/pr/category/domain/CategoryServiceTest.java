package com.pr.category.domain;

import com.pr.category.dto.request.CategoryCreateRequest;
import com.pr.category.dto.response.CategoryResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static com.pr.fixtures.Constants.조깅_카테고리_이름;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
@ActiveProfiles("test")
class CategoryServiceTest {

    private final CategoryCreateRequest 조깅_카테고리_생성_요청 = new CategoryCreateRequest(조깅_카테고리_이름);


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @DisplayName("카테고리를 생성한다.")
    @Test
    void 카테고리를_생성한다() {
        //given & when
        CategoryResponse actual = categoryService.save(조깅_카테고리_생성_요청);

        //then
        assertThat(actual.getName()).isEqualTo(조깅_카테고리_이름);
    }
}