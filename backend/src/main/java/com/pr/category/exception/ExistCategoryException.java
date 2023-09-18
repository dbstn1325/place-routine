package com.pr.category.exception;

public class ExistCategoryException extends RuntimeException{

    public ExistCategoryException(String message) {super(message);}

    public ExistCategoryException() {
        this("이미 등록된 카테고리 입니다.");
    }
}
