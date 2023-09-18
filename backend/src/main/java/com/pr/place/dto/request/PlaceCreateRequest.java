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
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class PlaceCreateRequest {
    @NotBlank(message = "공백일 수는 없습니다.")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime openDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime closeDateTime;

    @NotBlank(message = "공백일 수는 없습니다.")
    private Location location;

    @NotBlank(message = "공백일 수는 없습니다.")
    private String memo;

    @NotBlank(message = "공백일 수는 없습니다.")
    private Long categoryId;


    public Place toEntity(Category category, Point point) {
        return Place.builder()
                .category(category)
                .name(this.name)
                .openDateTime(this.openDateTime)
                .closeDateTime(this.closeDateTime)
                .location(this.location)
                .memo(this.memo)
                .point(point)
                .build();
    }


}
