package com.todoprac.todoprac.dto;

import com.todoprac.todoprac.entity.User;

public class UserDto {

    private Long id;
    private String username;
    private String email;

    public UserDto(Long id, String username, String email){
        this.id = id;
        this.username=username;
        this.email=email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    public static UserDto fromEntity(User user){
        return new UserDto(user.getId(), user.getUsername(), user.getEmail());
    }

}
