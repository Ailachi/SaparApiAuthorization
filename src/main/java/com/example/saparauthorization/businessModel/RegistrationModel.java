package com.example.saparauthorization.businessModel;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class RegistrationModel {
    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min=8, max=20, message = "Validation size error!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

}
