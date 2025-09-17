package com.gameclub.gameclub.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(IdNotPresentException.class)
    public String handleIdNotPresentException(IdNotPresentException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(BuisnessException.class)
    public String handleBuisnessException(BuisnessException ex) {
        return ex.getMessage();
    }
}
