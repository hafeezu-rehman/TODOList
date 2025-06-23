package com.project.todolist.model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERNAME", nullable = false, unique = false)
    private String username;
    @Column(name = "TODO", nullable = false, unique = false)
    private String toDo;
    @Column(name = "PRIORITY", nullable = false, unique = false)
    private String priority;
    @Column(name = "TODODATE", nullable = false, unique = false)
    private LocalDate toDoDate;
    public Task(){
    }
    public Task(Long id, String username, String toDo, String priority, LocalDate toDoDate) {
        this.id = id;
        this.username = username;
        this.toDo = toDo;
        this.priority = priority;
        this.toDoDate = toDoDate;
    }

    public LocalDate getToDoDate() {
        return toDoDate;
    }
    public void setToDoDate(LocalDate toDoDate) {
        this.toDoDate = toDoDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getToDo() {
        return toDo;
    }
    public void setToDo(String toDo) {
        this.toDo = toDo;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    
}
