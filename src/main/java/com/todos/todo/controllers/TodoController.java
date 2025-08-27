package com.todos.todo.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todos.todo.dtos.CreateTodoEditRequest;
import com.todos.todo.dtos.CreateTodoRequest;
import com.todos.todo.dtos.GetTodosResponse;
import com.todos.todo.entities.TodoEntity;
import com.todos.todo.services.TodoService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



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

    //3. delete Todo:
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id){
        todoService.DeleteTodo(id);
        return ResponseEntity.ok("Todo Deleted");
        
    }

    //4. Edit Todo => Put request
    @PutMapping("edit/{id}")
    public ResponseEntity<GetTodosResponse> EditTodo(@PathVariable Long id, @RequestBody CreateTodoEditRequest request){
        Optional<TodoEntity> todoOpt = todoService.editTodo(request, id);
        if(todoOpt.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(GetTodosResponse.fromEntity(todoOpt.get()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(GetTodosResponse.fromEntity(todoOpt.get()));


    }
    
    
    
}
