package com.pr.place.exception;

public class NoSuchPlaceCategoryException extends RuntimeException{

    public NoSuchPlaceCategoryException(String message) {
        super(message);
    }

    public NoSuchPlaceCategoryException() {
        this("존재하지 않는 플레이스 카테고리 입니다.");
    }
}
