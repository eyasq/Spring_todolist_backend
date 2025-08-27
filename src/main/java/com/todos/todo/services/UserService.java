package com.todos.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todos.todo.dtos.CreateUserRequest;
import com.todos.todo.dtos.EditUserRequestDTO;
import com.todos.todo.entities.UserEntity;
import com.todos.todo.repositories.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    //1. Create User
    public UserEntity addUser(CreateUserRequest request){
        UserEntity user = new UserEntity(request.getUsername(), request.getEmail(), request.getPassword());
        return userRepository.save(user);
    }

    //2. Edit User
    public Optional<UserEntity> editUser(EditUserRequestDTO request, Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent()){
            UserEntity userToEdit = user.get();
            if(request.getUsername()!=null) userToEdit.setUsername(request.getUsername());
            if(request.getEmail()!=null)userToEdit.setEmail(request.getEmail());
            if(request.getPassword()!=null)userToEdit.setPassword(request.getPassword());
            userRepository.save(userToEdit);
            return Optional.of(userToEdit);
        }
        return Optional.empty();
    }

    //3. Get Users(admin only, auth later)
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    //4. Delete user
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
