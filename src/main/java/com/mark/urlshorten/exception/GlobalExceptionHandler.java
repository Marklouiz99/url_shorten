package com.mark.urlshorten.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LinkNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleLinkNotFoundException(LinkNotFoundException ex) {
        return Map.of("error", ex.getMessage());
    }

    @ExceptionHandler(LinkExpiredException.class)
    @ResponseStatus(HttpStatus.GONE)
    public Map<String, String> handleLinkExpiredException(LinkExpiredException ex) {
        return Map.of("error", ex.getMessage());
    }
}
