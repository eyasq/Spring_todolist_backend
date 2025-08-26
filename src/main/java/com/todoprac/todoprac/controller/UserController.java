package com.todoprac.todoprac.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoprac.todoprac.dto.RegisterUserRequest;
import com.todoprac.todoprac.dto.UserDto;
import com.todoprac.todoprac.entity.User;
import com.todoprac.todoprac.service.UserService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    public UserController( UserService userService){
        this.userService = userService;
    }

    //1. Register user
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid RegisterUserRequest request) {
        User user = userService.createUser(request.getUsername(), request.getEmail(), request.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserDto.fromEntity(user));
    }

   
    //2. Login User

    

    //3. Edit User



    //4. Delete User
    
    
}
