package com.example.DistributedSystems.Payload.Request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    private String Username;

    @NotBlank
    private String Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
