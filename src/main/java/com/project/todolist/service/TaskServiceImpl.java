package com.project.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todolist.model.Task;
import com.project.todolist.repository.TaskRepository;


@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;
    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findTasksByUsername(String username) {
        return taskRepository.findByUsername(username);
    }

    @Override
    public Task addTask(Task task) {
        if(task.getToDo()==null || task.getToDoDate()==null)
            throw new IllegalArgumentException("To-do cannot be empty");
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task editTask(Task updatedTask) {
        if(updatedTask.getToDo()==null)
            throw new IllegalArgumentException("To-do cannot be empty");
        return taskRepository.findById(updatedTask.getId())
        .map(task -> {
            task.setToDo(updatedTask.getToDo());
            task.setPriority(updatedTask.getPriority());
            task.setToDoDate(updatedTask.getToDoDate());
            return taskRepository.save(task);
        })
        .orElseThrow(()->new RuntimeException("Task is not updated! Please Try Again"));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    @Override
    public Task findTaskByID(Long id) {
    return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
}


}
