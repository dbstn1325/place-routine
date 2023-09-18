package com.pr.place.domain;

import com.pr.category.domain.Category;
import lombok.*;

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

    private String name;

    @Column(name = "open_date_time", nullable = false)
    private LocalDateTime openDateTime;

    @Column(name = "close_date_time", nullable = false)
    private LocalDateTime closeDateTime;

    @Embedded
    private Location location;

    @Embedded
    private Feature feature;


    @ManyToOne
    @JoinColumn(name = "categories_id", nullable = false)
    private Category category;

    @Builder
    public Place(String name, LocalDateTime openDateTime, LocalDateTime closeDateTime, Location location, Feature feature, Category category) {
        this.name = name;
        this.openDateTime = openDateTime;
        this.closeDateTime = closeDateTime;
        this.location = location;
        this.feature = feature;
        this.category = category;
    }
}
