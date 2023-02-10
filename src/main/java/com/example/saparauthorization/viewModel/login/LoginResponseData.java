package com.example.saparauthorization.viewModel.login;

import com.example.saparauthorization.businessModel.UserModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseData {
    private UserModel user;
    private String token;
    private String refreshToken;
    public LoginResponseData(UserModel user, String token, String refreshToken) {
        this.user = user;
        this.token = token;
        this.refreshToken = refreshToken;

    }
}
