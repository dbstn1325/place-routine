package com.pr.place.dto.response;

import com.pr.place.domain.Category;
import com.pr.place.domain.Location;
import com.pr.place.domain.Place;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceResponse {

    private Long id;
    private String name;
    private String categoryType;
    private LocalDateTime openDateTime;
    private LocalDateTime closeDateTime;
    private Location location;
    private String memo;

    @Builder
    public PlaceResponse(Long id, String name, String categoryType, LocalDateTime openDateTime, LocalDateTime closeDateTime, Location location, String memo) {
        this.id = id;
        this.name = name;
        this.openDateTime = openDateTime;
        this.closeDateTime = closeDateTime;
        this.location = location;
        this.categoryType = categoryType;
        this.memo = memo;
    }

    // 플레이스 엔티티로부터 PlaceResponse dto 생성
    public static PlaceResponse fromEntity(Place place) {
        Category category = place.getCategory();

        return PlaceResponse.builder()
                .id(place.getId())
                .name(place.getName())
                .categoryType(category.getValue())
                .openDateTime(place.getOpenDateTime())
                .closeDateTime(place.getCloseDateTime())
                .location(place.getLocation())
                .memo(place.getMemo())
                .build();
    }
}
