package com.todos.todo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {
    @NotBlank(message="Username Cannot be blank.")
    @Size(min=3, max=16, message = "Username must be between 3 and 16 chars.")
    private String username;
    @NotBlank(message="Email cannot be blank.")
    @Email
    private String email;
    @Size(min=8, max=16, message="Password cannot be less than 8 or more than 16.")
    private String password;
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
