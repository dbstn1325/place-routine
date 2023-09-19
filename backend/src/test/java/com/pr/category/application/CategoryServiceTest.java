package com.pr.category.domain;

import com.pr.category.application.CategoryService;
import com.pr.category.dto.request.CategoryCreateRequest;
import com.pr.category.dto.response.CategoryResponse;
import com.pr.category.exception.ExistCategoryException;
import com.pr.category.exception.InvalidCategoryException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static com.pr.common.Constants.조깅_카테고리_이름;
import static org.assertj.core.api.Assertions.*;

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

    @ParameterizedTest
    @ValueSource(strings = {"", "일이삼사오육칠팔구십일이삼사오육칠팔구십일", "플레이스 루틴 플레이스 루틴 플레이스 루틴 카테고리"})
    void 카테고리를_생성할_때_이름이_공백이거나_길이가_20을_초과하면_예외가_발생한다(final String invalidName) {
        CategoryCreateRequest 카테고리_생성_요청 = new CategoryCreateRequest(invalidName);

        // when & then
        assertThatThrownBy(() -> categoryService.save(카테고리_생성_요청))
                .isInstanceOf(InvalidCategoryException.class);
    }

    @Test
    void 중복되는_카테고리를_생성하면_예외가_발생한다() {
        //given
        categoryService.save(조깅_카테고리_생성_요청);

        // when & then
        assertThatThrownBy(() -> categoryService.save(조깅_카테고리_생성_요청))
                .isInstanceOf(ExistCategoryException.class);
    }
}