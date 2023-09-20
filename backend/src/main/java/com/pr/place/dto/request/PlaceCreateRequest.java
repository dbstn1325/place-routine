package com.pr.place.dto.request;

import com.pr.category.domain.Category;
import com.pr.place.domain.Location;
import com.pr.place.domain.Place;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class PlaceCreateRequest {
    @NotBlank(message = "공백일 수는 없습니다.")
    private String name;

    @NotNull(message = "카테고리를 입력해주세요.")
    private String categoryType;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime openDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime closeDateTime;

    private Location location;


    @NotBlank(message = "공백일 수는 없습니다.")
    private String memo;

    public Place toEntity(Point point) {
        return Place.builder()
                .name(this.name)
                .category(categoryType)
                .openDateTime(this.openDateTime)
                .closeDateTime(this.closeDateTime)
                .location(this.location)
                .memo(this.memo)
                .point(point)
                .build();
    }


}
