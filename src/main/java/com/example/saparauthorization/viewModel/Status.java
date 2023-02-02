package com.example.saparauthorization.viewModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {
    private String statusCode;
    private String statusCodeDesc;

    public Status(){}
    public Status(String statusCode, String statusCodeDesc) {
        this.statusCode = statusCode;
        this.statusCodeDesc = statusCodeDesc;
    }

}
