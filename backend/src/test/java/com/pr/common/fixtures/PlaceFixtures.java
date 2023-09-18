package com.pr.common.fixtures;

import com.pr.category.domain.Category;
import com.pr.place.domain.Location;
import com.pr.place.domain.Place;
import com.pr.place.dto.request.PlaceCreateRequest;

import java.time.LocalDateTime;

import static com.pr.common.fixtures.CategoryFixtures.테스트_카테고리_아이디;

public class PlaceFixtures {

    public static final LocalDateTime 날짜_2023년_9월_18일_11시_0분 = LocalDateTime.of(2023, 9, 18, 11, 0);
    public static final LocalDateTime 날짜_2023년_9월_19일_11시_0분 = LocalDateTime.of(2023, 9, 19, 11, 0);

    public static final String 테스트_플레이스_명 = "투썸 플레이스";
    public static final LocalDateTime 플레이스_오픈_일시 = LocalDateTime.of(2023, 9, 18, 11, 0);
    public static final LocalDateTime 플레이스_마감_일시 = LocalDateTime.of(2023, 9, 19, 11, 0);
    public static final Location 테스트_플레이스_위치 = new Location(35.180563157689654, 128.09436303925034);
    public static final String 테스트_메모 = "음악 소리가 시끄러워요";


    public static final PlaceCreateRequest 플레이스_생성_요청  = new PlaceCreateRequest(
            테스트_플레이스_명,
            플레이스_오픈_일시,
            플레이스_마감_일시,
            테스트_플레이스_위치,
            테스트_메모,
            테스트_카테고리_아이디
    );

    public static Place 테스트_플레이스(final Category category){
        return Place.builder()
                .name(테스트_플레이스_명)
                .openDateTime(플레이스_오픈_일시)
                .closeDateTime(플레이스_마감_일시)
                .location(테스트_플레이스_위치)
                .memo(테스트_메모)
                .category(category)
                .build();
    }
}