package com.example.saparauthorization.controller;

import com.example.saparauthorization.businessModel.UserModel;
import com.example.saparauthorization.service.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/getAll")
    public List<UserModel> getUsers() {
        return userService.findAll();
    }
}
