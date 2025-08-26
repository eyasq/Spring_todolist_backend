package com.todoprac.todoprac.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todoprac.todoprac.entity.User;
import com.todoprac.todoprac.repository.UserRepository;

@Service
public class UserService {
    //createUser(username, email, pw), findByUsername(username), checkExist(username, email)

    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //1. Create User
    public User createUser(String username, String email, String password){
        User user = new User(username, email, password);
        return userRepository.save(user);
    }


    //2. Edit user profiel
    public Optional<User> editUser(Long id, String username, String email, String password, User user){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User userToEdit = userOptional.get();
            if(!userToEdit.getId().equals(user.getId())){
                return Optional.empty();
            }
            if(username != null) userToEdit.setUsername(username);
            if(email != null) userToEdit.setEmail(email);
            if (password!=null) userToEdit.setPassword(password);
            return Optional.of(userRepository.save(userToEdit));
        }

        return Optional.empty();
    }
    

    //3. Delete User
    public Boolean deleteUser(Long id, User user){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
           User userToDelete = userOptional.get();
           if(!userToDelete.getId().equals(user.getId())){
                return false;
           }
           userRepository.delete(userToDelete);
           return true;
        }
        return false;
    }
}
