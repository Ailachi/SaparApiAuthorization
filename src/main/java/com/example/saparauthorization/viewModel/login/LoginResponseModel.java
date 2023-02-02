package com.example.saparauthorization.viewModel.login;

import com.example.saparauthorization.util.Util;
import com.example.saparauthorization.viewModel.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseModel {
    private Status status;
    private LoginResponseData responseData;

    public LoginResponseModel() {}
    public LoginResponseModel(LoginResponseData responseData) {
        this.status = new Status(Util.SUCCESS_CODE, Util.SUCCESS_MESSAGE);
        this.responseData = responseData;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LoginResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(LoginResponseData responseData) {
        this.responseData = responseData;
    }
}
