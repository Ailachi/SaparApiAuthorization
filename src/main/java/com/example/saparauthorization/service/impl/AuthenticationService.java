package com.example.saparauthorization.service.impl;

import com.example.saparauthorization.businessModel.LoginModel;
import com.example.saparauthorization.businessModel.UserModel;
import com.example.saparauthorization.service.IAuthenticationService;
import org.springframework.stereotype.Service;


public class AuthenticationService implements IAuthenticationService {

    @Override
    public UserModel login(LoginModel model) {
        return new UserModel();
    }
}
