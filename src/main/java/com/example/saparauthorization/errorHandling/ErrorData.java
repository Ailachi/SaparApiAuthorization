package com.example.saparauthorization.errorHandling;

import com.example.saparauthorization.viewModel.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorData {
    private Status status;
    private String errorMessage;



    public ErrorData(Status status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
