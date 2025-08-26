package com.todoprac.todoprac.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateTodoRequest {
    @NotBlank
    @Size(max=50)
    private String title;

    private String notes;

    @NotNull
    private LocalDate due_by;

    private Boolean important;

    private Boolean completed;

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
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

    public LocalDate getDue_by() {
        return due_by;
    }

    public void setDue_by(LocalDate due_by) {
        this.due_by = due_by;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }
    
    
}
