package com.pocs.MarketProject.controller;

import com.pocs.MarketProject.exceptions.InvalidDataException;
import com.pocs.MarketProject.exceptions.ResourceNotFound;
import com.pocs.MarketProject.utils.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(InvalidDataException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public ApiErrors handleInvalidDataException(InvalidDataException ex){
        String errorMessage = ex.getMessage();
        return new ApiErrors(errorMessage);
    }

    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ApiErrors handleResourceNotFoundException(ResourceNotFound ex){
        String errorMessage = ex.getMessage();
        return new ApiErrors(errorMessage);
    }
}
