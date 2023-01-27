package com.example.saparauthorization.viewModel.login;

import com.example.saparauthorization.viewModel.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseModel {
    private Status status;
    private LoginResponseData responseData;
}
