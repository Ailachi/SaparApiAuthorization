package com.example.saparauthorization.service.authentication;

import com.example.saparauthorization.businessModel.LoginModel;
import com.example.saparauthorization.businessModel.UserModel;
import com.example.saparauthorization.mappers.SaparMapper;
import com.example.saparauthorization.service.Users.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

    private UserService userService;
    private SaparMapper mapper;

    public AuthenticationService() {

    }
    @Autowired
    public AuthenticationService(UserService userService, SaparMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }
    @Override
    public UserModel login(@Valid LoginModel model) throws Exception {
        UserModel userModel = userService.findUserByEmailAndPassowrd(model.getEmail(), model.getPassword());
        return userModel;
    }
}
