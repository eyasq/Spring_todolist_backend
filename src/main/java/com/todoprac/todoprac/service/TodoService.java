package com.todoprac.todoprac.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.todoprac.todoprac.TodopracApplication;
import com.todoprac.todoprac.entity.Todo;
import com.todoprac.todoprac.entity.User;
import com.todoprac.todoprac.repository.TodoRepository;

@Service
public class TodoService {

    //Create Todo(TodoData, user), getTodosByUser, getCompletedTodosByUser, updateTodos, deleteTodo
    private final TodoRepository todoRepository;

    //@Autowired // this autowired isn't needed. why? Because modern spring automatically autowires! we only need to annotate with @Autowired if there are multiple constructors or spring <4.3
    public TodoService(TodoRepository todoRepository, TodopracApplication todopracApplication){
        this.todoRepository = todoRepository;
    }
    //1. Create todo:
    public Todo createTodo(String title, String notes, LocalDate due_by, Boolean important, User user){
        Todo todo = new Todo(title, notes, due_by, user);
        if(important!= null){
            todo.setImportant(important);
        }
        return todoRepository.save(todo);
    }
    //2. Get todos by user:
    public List<Todo> getTodoByUser(User user){
        return todoRepository.findByUser(user);
    }

    //3. Get completed todos by user:
    public List<Todo> getCompletedTodosByUser(User user){
        return todoRepository.findByUserAndCompleted(user, true);
    }

    //4. getTodoEdit
    public Optional<Todo> getTodoById(Long id, User user){
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if(todoOptional.isPresent()){
            Todo todo = todoOptional.get();
            if(todo.getUser().getid().equals(user.getid())){
                return todoOptional;
            }
        }
        return Optional.empty();
    }

    //5. Edit the view you got:
    public Optional<Todo> updateTodo(Long id, String title, String notes, Boolean completed, Boolean important, LocalDate due_by, User user){

        Optional<Todo> todoOptional = todoRepository.findById(id);
        if(todoOptional.isPresent()){
            Todo todo = todoOptional.get();
            if(!todo.getUser().getid().equals(user.getid())){
                return Optional.empty();
            }
            if (title != null) todo.setTitle(title);
            if (notes != null) todo.setNotes(notes);
            if (completed != null) todo.setNotes(notes);
            if (important != null) todo.setNotes(notes);
            if (due_by != null) todo.setNotes(notes);
            return Optional.of(todoRepository.save(todo));
        }
        return Optional.empty();
    }

    //6. Delete todo
    public Boolean deleteTodo(Long id, User user){
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()){
            if(todoOptional.get().getUser().getid().equals(user.getid())){
                todoRepository.deleteById(id);
                return true;
            }
        }
        return false;
    }

    //7. Todo exists?

    public Boolean todoExists(Long id){
        return todoRepository.existsById(id);
    }
}
