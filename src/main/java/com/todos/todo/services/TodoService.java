package com.todos.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todos.todo.dtos.CreateTodoEditRequest;
import com.todos.todo.dtos.CreateTodoRequest;
import com.todos.todo.entities.TodoEntity;
import com.todos.todo.repositories.TodoRepository;

@Service
public class TodoService {
    
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    //1. Create/add Todo
    public TodoEntity addTodo(CreateTodoRequest request){
        Boolean important = request.getImportant();
        if(important==null){important=false;}
        TodoEntity todo = new TodoEntity(
            request.getTitle(), request.getNotes(), important, request.getDueBy()
            );
        return todoRepository.save(todo);
    }

    //2. Get Completed Todos:
    public List<TodoEntity> getCompletedTodos(){
        List<TodoEntity> todos = todoRepository.findByCompleted(true);
        return todos;
    }

    //3. Get all Todos:
    public List<TodoEntity> getAllTodos(){
        List<TodoEntity> todos = todoRepository.findAll();
        return todos;
    }

    //4. get todo by id
    public Optional<TodoEntity> getTodoById(Long id){
        return todoRepository.findById(id);

    }

    //4,5. Edit todo
    public Optional<TodoEntity> editTodo(CreateTodoEditRequest request, Long id){
        Optional<TodoEntity> todoToEditOp = todoRepository.findById(id);
        if (todoToEditOp.isPresent()){
            TodoEntity todoToEdit = todoToEditOp.get();
        if (request.getTitle()!= null) todoToEdit.setTitle(request.getTitle());
        if(request.getNotes() !=null) todoToEdit.setNotes(request.getNotes());
        if (request.getImportant() != null) todoToEdit.setImportant(request.getImportant());
        if (request.getCompleted()!=null) todoToEdit.setCompleted(request.getCompleted());
        if (request.getDueBy()!=null) todoToEdit.setDueBy(request.getDueBy());
        return Optional.of(todoRepository.save(todoToEdit));
        }
        return Optional.empty();

    }


    //5. Delete Todo
    public void DeleteTodo(Long id){
        Optional<TodoEntity> todoToDeleteOpt = todoRepository.findById(id);
        if (todoToDeleteOpt.isPresent()){
            TodoEntity todoToDelete = todoToDeleteOpt.get();
            todoRepository.delete(todoToDelete);
            return;
        }
        System.out.println("Todo Does not exist?");
    }
}
