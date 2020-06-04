package com.pocs.MarketProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "E-mail já cadastrado")
public class UserExistsException extends RuntimeException{

    public UserExistsException(String message){
        super(message);
    }
}
