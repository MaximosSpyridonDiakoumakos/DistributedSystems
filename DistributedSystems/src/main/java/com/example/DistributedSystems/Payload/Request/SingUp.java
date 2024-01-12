package com.example.DistributedSystems.Payload.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class SingUp {

    @NotBlank
    @Size(min = 3, max = 30)
    private String Username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String Email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
