package com.pr.place.application;

import com.pr.category.domain.Category;
import com.pr.category.domain.CategoryRepository;
import com.pr.place.domain.Place;
import com.pr.place.domain.PlaceRepository;
import com.pr.place.dto.request.PlaceCreateRequest;
import com.pr.place.dto.response.PlaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final CategoryRepository categoryRepository;

    public PlaceResponse save(PlaceCreateRequest request) {
        Category category = categoryRepository.getById(request.getCategoryId());
        Place place = request.toEntity(category);
        Place savedPlace = placeRepository.save(place);
        return new PlaceResponse(savedPlace);
    }
}
