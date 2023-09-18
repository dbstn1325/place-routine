package com.pr.category;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pr.category.application.CategoryService;
import com.pr.category.dto.request.CategoryCreateRequest;
import com.pr.category.dto.response.CategoryResponse;
import com.pr.category.exception.InvalidCategoryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static com.pr.common.fixtures.CategoryFixtures.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureRestDocs
@WebMvcTest({CategoryController.class})
@ActiveProfiles("test")
class CategoryControllerTest {
    private static final String CATEGORY_NAME_OVER_LENGTH_EXCEPTION_MESSAGE = "카테고리 이름의 길이는 20을 초과할 수 없습니다.";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @DisplayName("사용자가 카테고리를 생성하면 상태코드 201을 반환한다")
    @Test
    void 사용자가_카테고리를_생성하면_상태코드_201을_반환한다() throws Exception {
        //given & when & then
        mockMvc.perform(post("/api/categories")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(자격증_공부_카테고리_생성_요청))
        ).andDo(print())
                .andExpect(status().isCreated());
    }

    @DisplayName("잘못된 이름 형식으로 카테고리를 생성하면 상태코드 400을 반환한다.")
    @Test
    void 잘못된_이름_형식으로_카테고리를_생성하면_상태코드_400을_반환한다() throws Exception {
        //given
        CategoryCreateRequest 잘못된_카테고리_생성_요청 = new CategoryCreateRequest(잘못된_카테고리);
        willThrow(new InvalidCategoryException(CATEGORY_NAME_OVER_LENGTH_EXCEPTION_MESSAGE))
                .given(categoryService)
                .save(any(CategoryCreateRequest.class));

        //when & then
        mockMvc.perform(post("/api/categories")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(잘못된_카테고리_생성_요청))
                ).andDo(print())
                .andExpect(status().isBadRequest());
    }


}