package com.example.saparauthorization.util;

import lombok.Getter;
import lombok.Setter;


public class Status {
    private String statusCode;
    private String statusCodeDesc;

    public Status() {}

    public Status(String statusCode, String statusCodeDesc) {
        this.statusCode = statusCode;
        this.statusCodeDesc = statusCodeDesc;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCodeDesc() {
        return statusCodeDesc;
    }

    public void setStatusCodeDesc(String statusCodeDesc) {
        this.statusCodeDesc = statusCodeDesc;
    }
}
