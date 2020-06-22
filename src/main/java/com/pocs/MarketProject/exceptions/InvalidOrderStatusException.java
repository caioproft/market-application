package com.pocs.MarketProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidOrderStatusException extends RuntimeException {

    public InvalidOrderStatusException(String message){
        super(message);
    }
}
