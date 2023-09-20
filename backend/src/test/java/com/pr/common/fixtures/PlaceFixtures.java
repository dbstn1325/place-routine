package com.pr.common.fixtures;

import com.pr.place.domain.Category;
import com.pr.place.domain.Location;
import com.pr.place.domain.Place;
import com.pr.place.dto.request.PlaceCreateRequest;
import com.pr.place.dto.request.PlaceLocationRequest;
import com.pr.place.dto.response.PlaceResponse;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import java.time.LocalDateTime;

import static com.pr.common.fixtures.CategoryFixtures.자격증_카테고리_생성_응답;


public class PlaceFixtures {

    public static final String 테스트_플레이스_명 = "투썸 플레이스";
    public static final String 테스트_코딩_카테고리 = Category.CODING.getValue();
    public static final String 테스트_존재하지_않는_카테고리 = "존재하지 않는 카테고리";
    public static final LocalDateTime 테스트_플레이스_오픈_시간 = LocalDateTime.of(2023, 9, 18, 11, 0);
    public static final LocalDateTime 테스트_플레이스_마감_시간 = LocalDateTime.of(2023, 9, 19, 11, 0);
    public static final Location 테스트_플레이스_위치 = new Location(35.180563157689654, 128.09436303925034);
    public static final Location 테스트_플레이스_위치_반경_1km_위치 = new Location(35.154073772575536, 128.09910296836372);
    public static final Location 테스트_플레이스_위치_반경_5km_위치 = new Location(35.154148196084165, 128.0995923238075);
    public static final Location 테스트_플레이스_위치_반경_10km_위치 = new Location(35.154309227790385, 128.1012131965846);

    public static final Double 테스트_사용자_위치_위도 = 35.15316467444626;
    public static final Double 테스트_사용자_위치_경도 = 128.0997135227073;
    public static final String 테스트_메모 = "음악 소리가 시끄러워요";
    public static final Point 테스트_포인트;

    static {
        try {
            테스트_포인트 = (Point) new WKTReader().read(String.format("POINT(%s %s)", 테스트_플레이스_위치.getLatitude(), 테스트_플레이스_위치.getLongitude()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final PlaceLocationRequest 사용자_위치_내_주변_플레이스_조회_요청  = new PlaceLocationRequest(
            테스트_사용자_위치_위도,
            테스트_사용자_위치_경도
    );

    public static final PlaceCreateRequest 플레이스_생성_요청  = new PlaceCreateRequest(
            테스트_플레이스_명,
            테스트_코딩_카테고리,
            테스트_플레이스_오픈_시간,
            테스트_플레이스_마감_시간,
            테스트_플레이스_위치,
            테스트_메모
    );


    public static Place 테스트_플레이스(){
        return Place.builder()
                .name(테스트_플레이스_명)
                .openDateTime(테스트_플레이스_오픈_시간)
                .closeDateTime(테스트_플레이스_마감_시간)
                .location(테스트_플레이스_위치)
                .memo(테스트_메모)
                .category(테스트_코딩_카테고리)
                .build();
    }

    public static PlaceResponse 반경_내_플레이스_응답(Long id, Location location) {
        return PlaceResponse.builder()
                .id(id)
                .name(테스트_플레이스_명)
                .categoryType(테스트_코딩_카테고리)
                .openDateTime(테스트_플레이스_오픈_시간)
                .closeDateTime(테스트_플레이스_마감_시간)
                .location(location)
                .memo(테스트_메모)
                .build();
        }

}
