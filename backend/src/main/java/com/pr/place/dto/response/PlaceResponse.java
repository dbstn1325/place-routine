package com.pr.place.dto.response;

import com.pr.place.domain.Place;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PlaceResponse {

    private Long id;
    private String name;

    public PlaceResponse(Place place) {
        this.id = place.getId();
        this.name = place.getName();
    }
}
