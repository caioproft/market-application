package com.pocs.MarketProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CategoryNotFound extends RuntimeException {

    public CategoryNotFound(String message) {
        super(message);
    }
}
