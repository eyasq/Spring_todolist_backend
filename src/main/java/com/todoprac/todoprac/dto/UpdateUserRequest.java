package com.todoprac.todoprac.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateUserRequest{
    @Size(max=50, message="Username exceeded char limit (50)")
    @NotBlank
    private String username;
    @NotBlank
    @Size(max=50, message="Email exceeded char limit (50)")
    @Email(message="Please Input Valid Email")
    private String email;

    @Size(min = 8, message="Password Must be at least 8 chars")
    private String password;

    public UpdateUserRequest(){}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
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