package com.project.todolist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
    @Id
    @Column(name = "USERNAME", length = 15)
    private String username;
    @Column(name = "PASSWORD", nullable = false, unique = false)
    private String password;
    @Column(name = "NAME", nullable = false, unique = false)
    private String name;

    public User(){

    }
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
