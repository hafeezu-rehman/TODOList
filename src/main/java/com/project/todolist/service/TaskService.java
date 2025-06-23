package com.project.todolist.service;
import com.project.todolist.model.*;
import java.util.List;

public interface TaskService {
    public List<Task> findTasksByUsername(String user);
    public Task addTask(Task task);
    public Task editTask(Task task);
    public void deleteTask(Long id);
    public Task findTaskByID(Long id);
}
