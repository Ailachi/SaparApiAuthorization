package com.example.saparauthorization.businessModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class LoginModel {

    @NotNull
    private String email;

    @NotNull
    @Min(8)
    @Pattern(regexp = "[A-z]", message = "password should be")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
