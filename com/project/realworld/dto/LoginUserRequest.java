package com.project.realworld.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class LoginUserRequest {

    @NotNull
    @NotBlank(message = "The email is required")
    @NotEmpty
    private String email;

    @NotNull
    @NotBlank(message = "The password is required")
    @NotEmpty
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
