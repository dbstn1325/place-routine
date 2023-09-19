package com.pr.place.dto.response;

import com.pr.category.domain.Category;
import com.pr.category.dto.response.CategoryResponse;
import com.pr.place.domain.Location;
import com.pr.place.domain.Place;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceResponse {

    private Long id;
    private String name;
    private CategoryResponse category;
    private LocalDateTime openDateTime;
    private LocalDateTime closeDateTime;
    private Location location;
    private String memo;

    @Builder
    public PlaceResponse(Long id, String name, CategoryResponse category, LocalDateTime openDateTime, LocalDateTime closeDateTime, Location location, String memo) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.openDateTime = openDateTime;
        this.closeDateTime = closeDateTime;
        this.location = location;
        this.memo = memo;
    }

    // 플레이스 엔티티로부터 PlaceResponse dto 생성
    public static PlaceResponse fromEntity(Place place) {
        return PlaceResponse.builder()
                .id(place.getId())
                .name(place.getName())
                .category(new CategoryResponse(place.getCategory()))
                .openDateTime(place.getOpenDateTime())
                .closeDateTime(place.getCloseDateTime())
                .location(place.getLocation())
                .memo(place.getMemo())
                .build();
    }
}
