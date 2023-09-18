package com.pr.place.domain;

import com.pr.category.domain.Category;
import lombok.*;
import org.locationtech.jts.geom.Point;


import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "places")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categories_id", nullable = false)
    private Category category;

    private String name;

    @Column(name = "open_date_time", nullable = false)
    private LocalDateTime openDateTime;

    @Column(name = "close_date_time", nullable = false)
    private LocalDateTime closeDateTime;

    @Embedded
    private Location location;

    @Embedded
    private Feature feature;

    @Column
    private Point point;


    @Builder
    public Place(Category category, String name, LocalDateTime openDateTime, LocalDateTime closeDateTime, Location location, Feature feature, Point point) {
        this.category = category;
        this.name = name;
        this.openDateTime = openDateTime;
        this.closeDateTime = closeDateTime;
        this.location = location;
        this.feature = feature;
        this.point = point;
    }
}
