package com.pr.place.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Location {

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;
}
