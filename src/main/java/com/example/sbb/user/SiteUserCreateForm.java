package com.example.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiteUserCreateForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "Username is required.")
    private String username;

    @NotEmpty(message = "Password is required.")
    private String password;

    @NotEmpty(message = "Password confirmation is required.")
    private String passwordConfirmation;

    @NotEmpty(message = "Email is required.")
    @Email
    private String email;
}
