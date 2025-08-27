package com.todos.todo.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateTodoEditRequest {
    @NotBlank(message="Title cannot be blank")
    @Size(max=50, message="Title cannot be over 50 chars")
    private String title;
    @Size(max=50, message="Notes cannot be over 50 chars")
    private String notes;
    @NotNull(message = "Completed cannot be blank")
    private Boolean completed;
    @NotNull
    private Boolean important;
    @NotNull
    private LocalDate dueBy;
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
    public Boolean getCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
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
