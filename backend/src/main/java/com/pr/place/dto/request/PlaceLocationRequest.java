package com.pr.place.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class PlaceLocationRequest {

    @NotBlank(message = "공백일 수는 없습니다.")
    private Double latitude;

    @NotBlank(message = "공백일 수는 없습니다.")
    private Double longitude;
}
