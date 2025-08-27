package com.todos.todo.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todos.todo.dtos.CreateTodoRequest;
import com.todos.todo.dtos.GetTodosResponse;
import com.todos.todo.entities.TodoEntity;
import com.todos.todo.services.TodoService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;


    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    //1. Create Todo:
    @PostMapping("add")
    public ResponseEntity<GetTodosResponse> CreateTodo(@Valid @RequestBody CreateTodoRequest request) {
        TodoEntity todo = todoService.addTodo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(GetTodosResponse.fromEntity(todo));
    }
    //2. Get Todos:
    @GetMapping
    public ResponseEntity<List<GetTodosResponse>> GetTodos() {
        List<TodoEntity> todos = todoService.getAllTodos();
        List<GetTodosResponse> todosDTO = todos.stream().map(GetTodosResponse::fromEntity).toList();
        return ResponseEntity.ok(todosDTO);
    }
    
    
    
}
