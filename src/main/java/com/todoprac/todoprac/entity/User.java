package com.todoprac.todoprac.entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;



@Entity //= this is a db table
@Table(name="users") // this table has a name users, dont use user as its a reserved word
public class User {
    
    @Id // = this is PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment this value
    private Long id;
    
    @NotBlank(message = "Username is a required field.") //field cant be empty
    @Size(max=50, message="Username must be less than 50 characters!") //field cant be over 50
    @Column(unique=true, nullable = false, length = 50) // = this is a db column
    private String username;

    @NotBlank(message="Email is a required field")
    @Email(message="Please input a valid email")
    @Size(max = 100, message = "Email must be less than 100 characters")
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @NotBlank(message = "Password is a required field")
    @Column(nullable = false)
    private String password;

    protected User(){} //default constructor required by JPA

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getid(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    
}
