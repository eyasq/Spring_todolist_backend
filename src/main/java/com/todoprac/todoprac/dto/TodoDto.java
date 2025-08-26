package com.todoprac.todoprac.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.todoprac.todoprac.entity.Todo;

public class TodoDto {
    private Long id;
    private String title;
    private String notes;
    private Boolean important;
    private Boolean completed;
    private LocalDate due_by;
    private LocalDateTime created_at;
    private String username;


    public TodoDto(Long id, String title, String notes, Boolean important, Boolean completed, LocalDate due_by,
            LocalDateTime created_at, String username) {
        this.id = id;
        this.title = title;
        this.notes = notes;
        this.important = important;
        this.completed = completed;
        this.due_by = due_by;
        this.created_at = created_at;
        this.username = username;
    }
    
    public static TodoDto fromEntity(Todo todo){
        return new TodoDto(todo.getId(), todo.getTitle(), todo.getNotes(), todo.getImportant(), todo.getCompleted(), todo.getDue_by(), todo.getCreated_at(), todo.getUser().getUsername());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDue_by() {
        return due_by;
    }

    public void setDue_by(LocalDate due_by) {
        this.due_by = due_by;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
    
        public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
