package com.example.saparauthorization.service.authentication;

import com.example.saparauthorization.businessModel.LoginModel;
import com.example.saparauthorization.businessModel.UserModel;

public interface IAuthenticationService {
    UserModel login(LoginModel model) throws Exception;
}
