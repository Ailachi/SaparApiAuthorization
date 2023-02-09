package com.example.saparauthorization.businessModel;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginModel {
    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min=8, max=20, message = "Validation size error!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-z])(?=.*[!@#&()–[{}]_:;',?/*~$^+=<>]).{8,20}$")
    private String password;
}
