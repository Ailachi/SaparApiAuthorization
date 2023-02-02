package com.example.saparauthorization.viewModel.login;

import com.example.saparauthorization.businessModel.UserModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseData {
    private UserModel user;

    public LoginResponseData(UserModel user) {
        this.user = user;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
