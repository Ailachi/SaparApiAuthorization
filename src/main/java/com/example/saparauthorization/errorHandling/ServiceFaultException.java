package com.example.saparauthorization.errorHandling;

public class ServiceFaultException extends Exception {
    private ErrorData errorData;

    public ServiceFaultException(ErrorData errorData) {

    }
}
