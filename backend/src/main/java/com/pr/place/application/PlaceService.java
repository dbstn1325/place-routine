package com.pr.place.application;

import com.pr.category.domain.CategoryRepository;
import com.pr.global.utils.GeometryUtil;
import com.pr.place.domain.Direction;
import com.pr.place.domain.Location;
import com.pr.place.domain.Place;
import com.pr.place.domain.PlaceRepository;
import com.pr.place.dto.request.PlaceCreateRequest;
import com.pr.place.dto.request.PlaceLocationRequest;
import com.pr.place.dto.response.PlaceResponse;
import lombok.RequiredArgsConstructor;

import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PlaceService {

    private final PlaceRepository placeRepository;
    private static final Double SEARCH_MAX_DISTANCE = 10.0;
    private final EntityManager em;

    @Transactional
    public PlaceResponse save(final PlaceCreateRequest request) throws ParseException {

        Point point = convertRequestToPoint(request);
        Place place = request.toEntity(point);

        Place savedPlace = placeRepository.save(place);
        return PlaceResponse.fromEntity(savedPlace);
    }

    public List<PlaceResponse> findPlacesByLocation(PlaceLocationRequest request) {
        Location northEast = GeometryUtil.calculate(request.getLatitude(), request.getLongitude(), SEARCH_MAX_DISTANCE, Direction.NORTHEAST.getBearing());
        Location southWest = GeometryUtil.calculate(request.getLatitude(), request.getLongitude(), SEARCH_MAX_DISTANCE, Direction.SOUTHWEST.getBearing());

        List<Place> places = searchPlacesWithinBounds(northEast, southWest);

        return convertPlacesToDTOs(places);
    }

    @Transactional
    public void delete(Long id) {
        Place place = placeRepository.getById(id);

        placeRepository.delete(place);
    }


    public List<Place> searchPlacesWithinBounds(Location northEast, Location southWest) {
        String pointFormat = String.format(
                "'LINESTRING(%f %f, %f %f)'",
                northEast.getLatitude(), northEast.getLongitude(), southWest.getLatitude(), southWest.getLongitude()
        );

        Query query = em.createNativeQuery(
                "" +
                        "SELECT * FROM places AS b WHERE MBRContains(ST_LINESTRINGFROMTEXT(" + pointFormat + "), b.point)",
                Place.class
        ).setMaxResults(10);

        return query.getResultList();
    }

    public List<PlaceResponse> convertPlacesToDTOs(List<Place> places) {
        return places.stream()
                .map(PlaceResponse::fromEntity)
                .collect(Collectors.toList());
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
