package com.pr.place.domain;

import com.pr.place.exception.NoSuchPlaceCategoryException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Category {
    CERTIFICATE("자격증"),
    DOCUMENTS("문서작업"),
    CODING("코딩"),
    Task("과제"),
    MEAL("밥먹기"),
    Rest("휴식"),
    Interview("면접준비"),
    STUDY("스터디"),
    EXERCISE("운동");

    private final String value;

    public static Category from(String value) {
        return Arrays.stream(values())
                .filter(bt -> bt.value.equals(value))
                .findFirst()
                .orElseThrow(NoSuchPlaceCategoryException::new);
    }

}
