package com.pr.place.presentation;

import com.pr.place.application.PlaceService;
import com.pr.place.dto.request.PlaceCreateRequest;
import com.pr.place.dto.request.PlaceLocationRequest;
import com.pr.place.dto.response.PlaceResponse;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.io.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @PostMapping("/categories/{categoryId}/places")
    public ResponseEntity<PlaceResponse> save(
            @PathVariable final Long categoryId,
            @Valid @RequestBody final PlaceCreateRequest request
    ) throws ParseException {
        PlaceResponse response = placeService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/places")
    public List<PlaceResponse> findPlacesByLocation(@ModelAttribute PlaceLocationRequest request) {
        return placeService.findPlacesByLocation(request);
    }

    @DeleteMapping("/places/{placeId}")
    public ResponseEntity<Void> delete(@PathVariable final Long placeId) {
        placeService.delete(placeId);
        return ResponseEntity.noContent().build();
    }



}
