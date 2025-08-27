package com.todos.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todos.todo.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
}
