package com.pr.place.domain;

import com.pr.category.domain.Category;
import com.pr.place.exception.InvalidPlaceException;
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

    private static final int MAX_MEMO_LENGTH = 255;
    private static final int MAX_TITLE_LENGTH = 50;

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
    private String memo;

    @Column
    private Point point;


    @Builder
    public Place(Category category, String name, LocalDateTime openDateTime, LocalDateTime closeDateTime, Location location, String memo, Point point) {
        validateMemoLength(memo);
        validateTitleLength(name);

        this.category = category;
        this.name = name;
        this.openDateTime = openDateTime;
        this.closeDateTime = closeDateTime;
        this.location = location;
        this.memo = memo;
        this.point = point;
    }

    private void validateMemoLength(final String memo) {
        if (memo.length() > MAX_MEMO_LENGTH) {
            throw new InvalidPlaceException(String.format("일정 메모의 길이는 %d를 초과할 수 없습니다.", MAX_MEMO_LENGTH));
        }
    }

    private void validateTitleLength(final String title) {
        if (title.length() > MAX_TITLE_LENGTH) {
            throw new InvalidPlaceException(String.format("일정 제목의 길이는 %d을 초과할 수 없습니다.", MAX_TITLE_LENGTH));
        }
    }


}
