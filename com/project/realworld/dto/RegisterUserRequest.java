package com.project.realworld.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    @NotNull
    @NotBlank(message = "The username is required")
    @NotEmpty
    private String username;

    @NotNull
    @NotBlank(message = "The email is required")
    @NotEmpty
    private String email;

    @NotNull
    @NotBlank(message = "The password is required")
    @NotEmpty
    private String password;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getList() {
        return List.of(username, email, password);
    }
}
