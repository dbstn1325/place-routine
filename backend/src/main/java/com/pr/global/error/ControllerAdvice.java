package com.pr.global.error;

import com.pr.category.exception.InvalidCategoryException;
import com.pr.category.exception.NoSuchCategoryException;
import com.pr.global.error.dto.ErrorResponse;
import com.pr.place.exception.InvalidPlaceException;
import com.pr.place.exception.NoSuchPlaceCategoryException;
import com.pr.place.exception.NoSuchPlaceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler({
            InvalidCategoryException.class,
            InvalidPlaceException.class
    })
    public ResponseEntity<ErrorResponse> handleInvalidData(final RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler({
            NoSuchCategoryException.class,
            NoSuchPlaceException.class,
            NoSuchPlaceCategoryException.class
    })
    public ResponseEntity<ErrorResponse> handleNoSuchData(final RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
