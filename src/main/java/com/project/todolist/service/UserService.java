package com.project.todolist.service;
import com.project.todolist.model.*;

public interface UserService {
    public void addUser(User user);
    public User findByUserName(String name);
}
