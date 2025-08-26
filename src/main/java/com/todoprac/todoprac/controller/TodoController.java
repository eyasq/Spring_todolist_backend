package com.todoprac.todoprac.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoprac.todoprac.dto.CreateTodoRequest;
import com.todoprac.todoprac.dto.TodoDto;
import com.todoprac.todoprac.entity.Todo;
import com.todoprac.todoprac.entity.User;
import com.todoprac.todoprac.service.TodoService;
import com.todoprac.todoprac.service.UserService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;
    private final UserService userService;
    public TodoController(TodoService todoService, UserService userService){
        this.todoService = todoService;
        this.userService = userService;
    }

    //1. Create Todo
    @PostMapping()
    public ResponseEntity<TodoDto> createTodo(@RequestBody @Valid CreateTodoRequest request) {
        User user = userService.findByUsername("eq1").orElseThrow();
        Todo todo = todoService.createTodo(
            request.getTitle(),
            request.getNotes(),
            request.getDue_by(),
            request.getImportant(),
            user
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(TodoDto.fromEntity(todo));
    }

    //2. get todos by user
    @GetMapping
    public ResponseEntity<List<TodoDto>> getTodos(){
        User user = userService.findByUsername("eq1").orElseThrow();
        List<TodoDto> todos = todoService.getTodosByUser(user).stream().map(TodoDto::fromEntity).toList();
        return ResponseEntity.ok(todos);
        
    }
    //3. Edit Todo
    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> editTodo(@PathVariable Long id, @RequestBody @Valid CreateTodoRequest request) {
        User user = userService.findByUsername("eq1").orElseThrow();
        Optional<Todo> updatedTodo = todoService.updateTodo(id, request.getTitle(), request.getNotes(), request.getCompleted(), request.getImportant(), request.getDue_by(), user);
        return updatedTodo
                .map(todo->ResponseEntity.ok(TodoDto.fromEntity(todo)))
                .orElse(ResponseEntity.notFound().build());
        
    }

    //4. Delete Todo
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTodo(@PathVariable Long id, User user){
        return ResponseEntity.ok(todoService.deleteTodo(id, user));

    }
    
}
