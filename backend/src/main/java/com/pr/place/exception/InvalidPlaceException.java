package com.pr.place.exception;

public class InvalidPlaceException extends RuntimeException{

    public InvalidPlaceException(String message) {
        super(message);
    }

    public InvalidPlaceException() {
        this("잘못된 플레이스입니다.");
    }
}
