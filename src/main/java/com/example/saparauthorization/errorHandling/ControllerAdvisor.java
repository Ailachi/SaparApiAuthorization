package com.example.saparauthorization.errorHandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ServiceFaultException.class)
    public void handleServiceFaultException() {

    }
}
