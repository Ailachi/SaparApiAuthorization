package com.example.saparauthorization.viewModel;

import com.example.saparauthorization.util.Util;
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

    public static Status Successful() {
        return new Status(Util.SUCCESS_CODE, Util.SUCCESS_MESSAGE);
    }

}
