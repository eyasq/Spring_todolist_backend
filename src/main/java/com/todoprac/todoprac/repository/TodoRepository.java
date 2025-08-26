package com.todoprac.todoprac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoprac.todoprac.entity.Todo;
import com.todoprac.todoprac.entity.User;

public interface TodoRepository extends JpaRepository<Todo, Long> { //This repo manages entities of type Todo which have an ID of type Long! that's what that generic means
    
    List<Todo> findByUser(User user);
    List<Todo> findByUserAndCompleted(User user, Boolean completed);
    Todo findById(Long id);
    void save(Todo todo);
    void deleteById(Long id);
    

}
