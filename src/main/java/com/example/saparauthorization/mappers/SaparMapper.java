package com.example.saparauthorization.mappers;

import com.example.saparauthorization.businessModel.LoginModel;
import com.example.saparauthorization.businessModel.RegistrationModel;
import com.example.saparauthorization.businessModel.UserModel;
import com.example.saparauthorization.model.Role;
import com.example.saparauthorization.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaparMapper {
    User RegistrationModelToUser(RegistrationModel registrationModel);
    RegistrationModel UserToRegistrationModel(User user);

    UserModel RegistrationModelToUserModel(RegistrationModel registrationModel);
    UserModel LoginModelToUser(LoginModel loginModel);
    LoginModel UserToLoginModel(UserModel userModel);

    @Mapping(source = "role", target = "roleName", qualifiedByName = "roleToRoleName")
    UserModel UserToUserModel(User user);

    @Named("roleToRoleName")
    static String RoleToRoleName(Role role) {
        return role.getRoleName();
    }

    List<UserModel> map(List<User> users);
}
