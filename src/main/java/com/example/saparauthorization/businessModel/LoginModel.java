package com.example.saparauthorization.businessModel;

import jakarta.validation.constraints.*;

public class LoginModel {
    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min=8, max=20, message = "Validation size error!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
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

    @Override
    public String toString() {
        return this.email;
    }
}
