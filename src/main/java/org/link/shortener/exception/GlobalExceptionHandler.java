package org.link.shortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionUrlNotFound() {
        ErrorDetails error = new ErrorDetails("Url not found");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}
