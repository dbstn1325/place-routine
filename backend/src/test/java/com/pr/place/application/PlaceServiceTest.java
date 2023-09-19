package com.pr.place.application;

import com.pr.category.application.CategoryService;
import com.pr.category.domain.Category;
import com.pr.category.domain.CategoryRepository;
import com.pr.place.domain.Place;
import com.pr.place.domain.PlaceRepository;
import com.pr.place.dto.request.PlaceCreateRequest;
import com.pr.place.dto.response.PlaceResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.List;

import static com.pr.common.fixtures.CategoryFixtures.테스트_카테고리;
import static com.pr.common.fixtures.PlaceFixtures.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
@ActiveProfiles("test")
class PlaceServiceTest {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @DisplayName("플레이스를 생성한다.")
    @Test
    void 플레이스를_생성한다() throws ParseException {
        //given
        Category 테스트_카테고리 = 테스트_카테고리();
        categoryRepository.save(테스트_카테고리);
        PlaceCreateRequest request = 플레이스_생성_요청;
        Long categoryId = 1L;

        //when
        PlaceResponse placeResponse = placeService.save(request, categoryId);
        Place actual = placeRepository.getById(placeResponse.getId());

        //then
        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.getLocation()).usingRecursiveComparison().isEqualTo(테스트_플레이스_위치),
                () -> assertThat(actual.getName()).isEqualTo(테스트_플레이스_명)
        );

    }

    @DisplayName("사용자의 위치 반경 10km 내의 부스를 전체 조회한다")
    @Test
    void 사용자의_위치_반경_10km_내의_부스를_전체_조회한다() throws ParseException {
        //given
        Category 테스트_카테고리 = 테스트_카테고리();
        Category savedCategory = categoryRepository.save(테스트_카테고리);
        placeService.save(플레이스_생성_요청, savedCategory.getId());

        //when
        List<PlaceResponse> nearbyPlaces = placeService.findPlacesNearLocation(사용자_위치_내_주변_플레이스_조회_요청);

        //then
        assertAll(
                () -> assertThat(nearbyPlaces).isNotNull(),
                () -> assertThat(nearbyPlaces).isNotEmpty(),
                () -> assertThat(nearbyPlaces.get(0).getLocation()).usingRecursiveComparison().isEqualTo(테스트_플레이스_위치),
                () -> assertThat(nearbyPlaces.get(0).getCategory().getName()).isEqualTo(savedCategory.getName()),
                () -> assertThat(nearbyPlaces.get(0).getName()).isEqualTo(테스트_플레이스_명)
        );
    }

}