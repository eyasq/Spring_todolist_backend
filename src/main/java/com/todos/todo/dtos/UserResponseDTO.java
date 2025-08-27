package com.todos.todo.dtos;

import com.todos.todo.entities.UserEntity;

public class UserResponseDTO {
    private String username;
    private String email;
    private String password;
    
    public UserResponseDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public static UserResponseDTO fromEntity(UserEntity user){
        UserResponseDTO dto = new UserResponseDTO(user.getUsername(), user.getEmail(), user.getPassword());
        return dto;
    }

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
