package com.todos.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todos.todo.entities.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findByCompleted(Boolean completed);
}
