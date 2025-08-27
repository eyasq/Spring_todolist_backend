package com.todos.todo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todos.todo.dtos.CreateUserRequest;
import com.todos.todo.dtos.EditUserRequestDTO;
import com.todos.todo.dtos.UserResponseDTO;
import com.todos.todo.entities.UserEntity;
import com.todos.todo.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //1. Create User
    @PostMapping(path="create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody CreateUserRequest request){
        UserEntity user = userService.addUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDTO.fromEntity(user));
    }
    //2. Edit User

    @PutMapping(path="edit/{id}")
    public ResponseEntity<UserResponseDTO> editUser(@RequestBody EditUserRequestDTO request, @PathVariable Long id){
        UserEntity user = userService.editUser(request, id).get();
        return ResponseEntity.status(HttpStatus.OK).body(UserResponseDTO.fromEntity(user));

    }
    //3. Delete user:
    @DeleteMapping(path="delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted user");
    }

    //4. Get user:
    @GetMapping("find")
    public ResponseEntity<List<UserResponseDTO>> getUser() {
        List<UserEntity> users = userService.getAllUsers();
        List<UserResponseDTO> usersList = users.stream().map(UserResponseDTO::fromEntity).toList();
        return ResponseEntity.status(HttpStatus.OK).body(usersList);
    }
    
}
