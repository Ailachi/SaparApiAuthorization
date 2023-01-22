package com.example.saparauthorization.mappers;

import com.example.saparauthorization.businessModel.LoginModel;
import com.example.saparauthorization.businessModel.RegistrationModel;
import com.example.saparauthorization.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaparMapper {
    User RegistrationModelToUser(RegistrationModel registrationModel);
    RegistrationModel UserToRegistrationModel(User userModel);

    User LoginModelToUser(LoginModel loginModel);
    LoginModel UserToLoginModel(User userModel);
}
