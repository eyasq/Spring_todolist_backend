package com.todoprac.todoprac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.todoprac.todoprac.controller.UserController;
import com.todoprac.todoprac.entity.User;
import com.todoprac.todoprac.repository.UserRepository;

@Service
public class UserService {

    private final UserController userController;
    //createUser(username, email, pw), findByUsername(username), checkExist(username, email)

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserController userController){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userController = userController;
    }

    //1. Create User
    public User createUser(String username, String email, String password){

        if(userRepository.findByUsername(username).isPresent()){
            throw new RuntimeException("Username taken");
        }
        else if(userRepository.findByEmail(email).isPresent()){
            throw new RuntimeException("Email already in use.");
        }
        String encodedPw = passwordEncoder.encode(password);

        User user = new User(username, email, encodedPw);
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

    //4. Login user:
    public Optional<User> loginUser(String username, String password){
        Optional<User> userOptional = userRepository.findByUsername(username);
        if(!userOptional.isPresent()){
            return Optional.empty();
        }
        User user = userOptional.get();
        if(passwordEncoder.matches(password, user.getPassword())){
            return userOptional;
        }
        return Optional.empty();
        //if userOptional.getPassword.equals(password) return userOptional
    }
    //5. Find user:
    public Optional<User> findByUsername(String username){
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) return userOptional;
        return Optional.empty();
    }

    public Optional<User> findById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user;
        }
        return Optional.empty();
    }
    public boolean userExists(String username, String email){
        return userRepository.findByEmail(email).isPresent() || userRepository.findByUsername(username).isPresent();
           
    }
    //6. find all users:
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
