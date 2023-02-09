package com.example.saparauthorization.service.Users;

import com.example.saparauthorization.businessModel.RegistrationModel;
import com.example.saparauthorization.businessModel.UserModel;


import java.util.List;

public interface IUserService {
    UserModel findUserById(long id) throws Exception;
    UserModel create(RegistrationModel model) throws Exception;
    UserModel findUserByEmail(String email) throws Exception;
    UserModel findUserByEmailAndPassword(String email, String password) throws Exception;

    List<UserModel> findAll();

}
