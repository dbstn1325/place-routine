package com.pr.place.dto.response;

import com.pr.category.domain.Category;
import com.pr.place.domain.Location;
import com.pr.place.domain.Place;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceResponse {

    private Long id;
    private String name;
    private Category category;
    private LocalDateTime openDateTime;
    private LocalDateTime closeDateTime;
    private Location location;
    private String memo;

    public PlaceResponse(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.category = place.getCategory();
        this.openDateTime = place.getOpenDateTime();
        this.closeDateTime = place.getCloseDateTime();
        this.location = place.getLocation();
        this.memo = place.getMemo();
    }

    @Builder
    public PlaceResponse(Long id, String name, Category category, LocalDateTime openDateTime, LocalDateTime closeDateTime, Location location, String memo) {
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
                .category(place.getCategory())
                .openDateTime(place.getOpenDateTime())
                .closeDateTime(place.getCloseDateTime())
                .location(place.getLocation())
                .memo(place.getMemo())
                .build();
    }
}
