package com.example.saparauthorization.util;

public class ApiResponse<T> {
    private Status status;
    private T responseData;

    public ApiResponse(Status status, T responseData) {
        this.status = status;
        this.responseData = responseData;
    }

    public ApiResponse(T responseData) {
        this.status = new Status();
        this.responseData = responseData;
    }

    public ApiResponse(String statusCode, String statusCodeDesc, T responseData) {
        this.status = new Status(statusCode, statusCodeDesc);
        this.responseData = responseData;
    }
}
