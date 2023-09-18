package com.pr.place.domain;

import com.pr.place.exception.NoSuchPlaceException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    default Place getById(final Long id) {
        return findById(id)
                .orElseThrow(NoSuchPlaceException::new);
    }
}
