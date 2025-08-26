package com.todoprac.todoprac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoprac.todoprac.entity.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findbyUsername(String username);
    Optional<User> findByEmail(String email);

}
