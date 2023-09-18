package com.pr.category.exception;

public class NoSuchCategoryException extends RuntimeException{

    public NoSuchCategoryException(String message) {
        super(message);
    }

    public NoSuchCategoryException() {
        this("잘못된 카테고리입니다.");
    }
}
