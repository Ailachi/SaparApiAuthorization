package com.example.saparauthorization.service.Users;

import com.example.saparauthorization.businessModel.UserModel;

import java.util.List;

public interface IUserService {
    UserModel findUserById(long id) throws Exception;
    UserModel create(UserModel userModel) throws Exception;
    UserModel findUserByEmail(String email) throws Exception;
    UserModel findUserByEmailAndPassowrd(String email, String password) throws Exception;

    List<UserModel> findAll();

}
