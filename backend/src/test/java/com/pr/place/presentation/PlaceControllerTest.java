package com.pr.place.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pr.category.presentation.CategoryController;
import com.pr.category.application.CategoryService;
import com.pr.common.DatabaseCleaner;
import com.pr.place.application.PlaceService;
import com.pr.place.dto.request.PlaceCreateRequest;
import com.pr.place.dto.response.PlaceResponse;
import com.pr.place.exception.NoSuchPlaceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.pr.common.fixtures.CategoryFixtures.*;
import static com.pr.common.fixtures.PlaceFixtures.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    @DisplayName("사용자가 플레이스를 목록을 정상적으로 조회하면 상태코드 200을 반환한다.")
    @Test
    void 사용자가_플레이스_목록을_정상적으로_조회하면_상태코드_200을_반환한다() throws Exception {
        //given

        PlaceResponse 반경_1km_내_플레이스_응답 = 반경_내_플레이스_응답(1L, 테스트_플레이스_위치_반경_1km_위치);
        PlaceResponse 반경_5km_내_플레이스_응답 = 반경_내_플레이스_응답(2L, 테스트_플레이스_위치_반경_5km_위치);
        PlaceResponse 반경_10km_내_플레이스_응답 = 반경_내_플레이스_응답(3L, 테스트_플레이스_위치_반경_10km_위치);

        given(placeService.findPlacesByLocation(any())).willReturn(
                List.of(반경_1km_내_플레이스_응답),
                List.of(반경_5km_내_플레이스_응답),
                List.of(반경_10km_내_플레이스_응답)
        );

        //when & then
        mockMvc.perform(
                        get("/api/places?latitude={latitude}&longitude={longitude}", 테스트_사용자_위치_위도, 테스트_사용자_위치_경도)
                ).andDo(print())
                .andDo(document("places/findPlacesByLocation",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(
                                parameterWithName("latitude").description("기준 플레이스 위도"),
                                parameterWithName("longitude").description("기준 플레이스 경도")
                        )
                ))
                .andExpect(status().isOk());
    }

    @DisplayName("플레이스를 제거하는데 성공하면 204를 반환한다.")
    @Test
    void 플레이스를_제거하는데_성공하면_204를_반환한다() throws Exception {
        // given
        Long placeId = 1L;
        willDoNothing()
                .given(placeService)
                .delete(any());

        // when & then
        mockMvc.perform(RestDocumentationRequestBuilders.delete("/api/places/{placeId}", placeId))
                .andDo(print())
                .andDo(document("place/delete",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("placeId").description("플레이스 ID")
                        )
                ))
                .andExpect(status().isNoContent());
    }

    @DisplayName("플레이스를 제거하는데 플레이스가 존재하지 않는 경우 404를 반환한다")
    @Test
    void 플레이스를_제거하는데_플레이스가_존재하지_않는_경우_404를_반환한다() throws Exception {
        // given
        Long placeId = 1L;
        willThrow(new NoSuchPlaceException())
                .given(placeService)
                .delete(any());

        // when & then
        mockMvc.perform(delete("/api/places/{placeId}", placeId))
                .andDo(print())
                .andDo(document("place/delete/failByNoPlace",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                ))
                .andExpect(status().isNotFound());
    }
}