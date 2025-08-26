package com.todoprac.todoprac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Todo title cannot be empty")
    @Size(max=50, message = "Todo Title too long")
    @Column(length = 50, nullable = false)
    private String title;

    @Column(nullable = true) //because notes are optional
    private String notes;

    @Column(nullable = false) //default = false
    private Boolean completed = false;

    @Column(nullable = false)
    private Boolean important = false;

    @Column(nullable = false)
    private LocalDate due_by;

    @CreationTimestamp
    @Column(nullable = false) // auto generated upon creation
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name= "user_id", nullable = false)
    private User user;

    protected Todo(){}

    public Todo(String title, String notes, LocalDate due_by, User user){
        this. title = title;
        this.notes = notes;
        this.due_by = due_by;
        this.user = user;
    }
    

    public Long getId() {
        return id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String toString(){
        return "Todo{" +
                "id=" + id +
                ", Title='" + title + '\'' +
                ", User='" + user + '\'' +
                '}';
    }
}
