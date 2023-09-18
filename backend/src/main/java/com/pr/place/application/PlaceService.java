package com.pr.place.application;

import com.pr.category.domain.Category;
import com.pr.category.domain.CategoryRepository;
import com.pr.place.domain.Location;
import com.pr.place.domain.Place;
import com.pr.place.domain.PlaceRepository;
import com.pr.place.dto.request.PlaceCreateRequest;
import com.pr.place.dto.response.PlaceResponse;
import lombok.RequiredArgsConstructor;

import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final CategoryRepository categoryRepository;

    public PlaceResponse save(PlaceCreateRequest request) throws ParseException {
        Category category = categoryRepository.getById(request.getCategoryId());

        Point point = convertRequestToPoint(request);
        Place place = request.toEntity(category, point);

        Place savedPlace = placeRepository.save(place);
        return new PlaceResponse(savedPlace);
    }



    public Point convertRequestToPoint(PlaceCreateRequest request) throws ParseException {
        return convertLocationToPoint(request.getLocation());
    }

    public Point convertLocationToPoint(Location location) throws ParseException {
        if (location != null) {
            return createPointFromCoordinates(location.getLatitude(), location.getLongitude());
        }
        return null;
    }

    public Point createPointFromCoordinates(Double latitude, Double longitude) throws ParseException {
        String pointWKT = String.format("POINT(%s %s)", latitude, longitude);
        return (Point) new WKTReader().read(pointWKT);
    }

}
