package com.pr.place.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pr.category.presentation.CategoryController;
import com.pr.category.application.CategoryService;
import com.pr.place.application.PlaceService;
import com.pr.place.dto.request.PlaceCreateRequest;
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
import static com.pr.common.fixtures.PlaceFixtures.플레이스_생성_요청;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureRestDocs
@WebMvcTest({PlaceController.class})
@ActiveProfiles("test")
class PlaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    protected PlaceService placeService;

    @MockBean
    protected CategoryService categoryService;


    @DisplayName("사용자가 플레이스를 생성하면 상태코드 201을 반환한다")
    @Test
    void 사용자가_플레이스를_생성하면_상태코드_201을_반환한다() throws Exception {
        //given
        Long categoryId = 1L;
        PlaceCreateRequest request = 플레이스_생성_요청;

        given(categoryService.save(any())).willReturn(자격증_카테고리_생성_응답());

        //when & then
        mockMvc.perform(post("/api/categories/{categoryId}/places", categoryId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                ).andDo(print())
                .andExpect(status().isCreated());
    }
}