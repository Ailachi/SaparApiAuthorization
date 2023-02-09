package com.example.saparauthorization.viewModel.login;

import com.example.saparauthorization.businessModel.UserModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseData {
    private UserModel user;
    private String token;
    public LoginResponseData(UserModel user, String token) {
        this.user = user;
        this.token = token;
    }
}
