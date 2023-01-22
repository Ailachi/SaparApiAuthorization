package com.example.saparauthorization.controller;

import com.example.saparauthorization.businessModel.LoginModel;
import com.example.saparauthorization.businessModel.RegistrationModel;
import com.example.saparauthorization.businessModel.UserModel;
import com.example.saparauthorization.mappers.SaparMapper;
import com.example.saparauthorization.model.User;
import com.example.saparauthorization.service.IAuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private SaparMapper mapper;
    private IAuthenticationService authenticationService;

    @Autowired
    public AuthController(SaparMapper mapper, IAuthenticationService authenticationService) {

        this.mapper = mapper;
        this.authenticationService = authenticationService;

    }

    @PostMapping("/register")
    public ResponseEntity<User>register(@RequestBody RegistrationModel model) {
        User user = mapper.RegistrationModelToUser(model);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserModel>login(@Valid @RequestBody LoginModel model) {

        return ResponseEntity.ok(authenticationService.login(model));
    }
}
