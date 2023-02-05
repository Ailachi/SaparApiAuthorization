package com.example.saparauthorization.service;

import com.example.saparauthorization.businessModel.UserModel;

public interface IUserService {
    UserModel findUserById(long id) throws Exception;
    UserModel create(UserModel userModel) throws Exception;
    UserModel findUserByEmail(String email) throws Exception;
    UserModel findUserByEmailAndPassowrd(String email, String password) throws Exception;


}
