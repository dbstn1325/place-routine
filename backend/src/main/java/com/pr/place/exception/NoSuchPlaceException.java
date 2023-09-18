package com.pr.place.exception;

public class NoSuchPlaceException extends RuntimeException{
    public NoSuchPlaceException(String message) {
        super(message);
    }

    public NoSuchPlaceException() {
        this("존재하지 않는 플레이스 입니다.");
    }


}
