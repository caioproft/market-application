package com.pocs.MarketProject.utils;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ApiErrors {

    private List<String> errors;

    public ApiErrors(String errorMessage){
        this.errors = Arrays.asList(errorMessage);
    }
}
