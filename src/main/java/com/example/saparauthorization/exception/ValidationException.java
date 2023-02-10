package com.example.saparauthorization.exception;

import com.example.saparauthorization.errorHandling.ErrorData;
import com.example.saparauthorization.util.Util;
import com.example.saparauthorization.viewModel.Status;

public class ValidationException extends Exception{
    public ErrorData errorData;

    public ValidationException(String errorMessage) {
        Status status = new Status(Util.VALIDATION_ERROR_CODE, Util.VALIDATION_ERROR_MESSAGE);
        this.errorData = new ErrorData(status, errorMessage);
    }
}
