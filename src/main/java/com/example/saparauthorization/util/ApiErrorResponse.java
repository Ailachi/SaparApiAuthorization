package com.example.saparauthorization.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorResponse {
    private Status status;
    private String errorMessage;

    public ApiErrorResponse(Status status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public ApiErrorResponse(String statusCode, String statusCodeDesc, String errorMessage) {
        this.status = new Status(statusCode, statusCodeDesc);
        this.errorMessage = errorMessage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
