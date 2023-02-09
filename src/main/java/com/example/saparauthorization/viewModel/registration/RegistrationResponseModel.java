package com.example.saparauthorization.viewModel.registration;

import com.example.saparauthorization.util.Util;
import com.example.saparauthorization.viewModel.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationResponseModel {
    Status status;
    RegistrationResponseData responseData;

    public RegistrationResponseModel(Status status, RegistrationResponseData responseData) {
        this.status = status;
        this.responseData = responseData;
    }

    public RegistrationResponseModel(RegistrationResponseData responseData) {
        this.status = new Status(Util.SUCCESS_CODE, Util.SUCCESS_MESSAGE);
        this.responseData = responseData;
    }
}
