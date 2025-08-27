package com.todos.todo.dtos;

import java.time.LocalDate;

import com.todos.todo.entities.TodoEntity;

public class GetTodosResponse {
    private String title;
    private String notes;
    private Boolean important;
    private LocalDate dueBy;

    public GetTodosResponse(String title, String notes, LocalDate dueBy, Boolean important){
        this.title = title;
        this.notes = notes;
        this.dueBy = dueBy;
        this.important = important;
    }
    

    public static GetTodosResponse fromEntity(TodoEntity todo){
        GetTodosResponse todoDTO = new GetTodosResponse(todo.getTitle(), todo.getNotes(), todo.getDueBy(), todo.getImportant());
        return todoDTO;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getNotes() {
        return notes;
    }


    public void setNotes(String notes) {
        this.notes = notes;
    }


    public Boolean getImportant() {
        return important;
    }


    public void setImportant(Boolean important) {
        this.important = important;
    }


    public LocalDate getDueBy() {
        return dueBy;
    }


    public void setDueBy(LocalDate dueBy) {
        this.dueBy = dueBy;
    }
    
}
