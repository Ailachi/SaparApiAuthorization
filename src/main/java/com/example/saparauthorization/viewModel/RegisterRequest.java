package com.example.saparauthorization.viewModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    String firstName;
    String lastName;
    String email;
    String password;
    String dob;
    String roleId;
}
