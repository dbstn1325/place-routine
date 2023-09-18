package com.pr.place.application;

import com.pr.category.application.CategoryService;
import com.pr.category.domain.Category;
import com.pr.category.domain.CategoryRepository;
import com.pr.place.domain.Place;
import com.pr.place.dto.request.PlaceCreateRequest;
import com.pr.place.dto.response.PlaceResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import static com.pr.common.fixtures.CategoryFixtures.테스트_카테고리;
import static com.pr.common.fixtures.PlaceFixtures.테스트_플레이스_명;
import static com.pr.common.fixtures.PlaceFixtures.플레이스_생성_요청;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest()
@ActiveProfiles("test")
class PlaceServiceTest {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private CategoryRepository categoryRepository;

    @DisplayName("플레이스를 생성한다.")
    @Test
    void 플레이스를_생성한다() {
        //given
        Category 테스트_카테고리 = 테스트_카테고리();
        categoryRepository.save(테스트_카테고리);
        PlaceCreateRequest request = 플레이스_생성_요청;

        //when
        PlaceResponse actual = placeService.save(request);

        //then
        assertThat(actual.getName()).isEqualTo(테스트_플레이스_명);
    }

}