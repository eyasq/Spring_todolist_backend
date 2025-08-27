package com.todos.todo.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateTodoRequest {
    @NotBlank(message = "Title Cannot be blank")
    @Size(max=50, message = "Title cant be over 50 chars")
    private String title;
    @Size(max=100, message="Notes cant be more than 100 chars")
    private String notes;
    @NotNull(message = "Due by Cannot be blank")
    private LocalDate dueBy;
    @NotNull(message = "Important Cannot be blank")
    private Boolean important;
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
    public LocalDate getDueBy() {
        return dueBy;
    }
    public void setDueBy(LocalDate dueBy) {
        this.dueBy = dueBy;
    }
    public Boolean getImportant() {
        return important;
    }
    public void setImportant(Boolean important) {
        this.important = important;
    }
    
}
