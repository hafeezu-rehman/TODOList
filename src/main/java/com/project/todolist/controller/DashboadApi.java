package com.project.todolist.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.todolist.model.Task;
import com.project.todolist.service.TaskService;

@RestController
public class DashboadApi {
    @Autowired
    public TaskService taskService;

    private String returnUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return username;
    }

    @GetMapping("/api/task/find")
    public ResponseEntity<List<Task>> displayTasks(Model model) {
        List<Task> allTasks = taskService.findTasksByUsername(returnUsername());
        model.addAttribute("task", allTasks);
        return ResponseEntity.ok(allTasks);
    }

    @PostMapping("/api/task/add")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        if (task.getToDoDate().compareTo(LocalDate.now()) >= 0) {
            task.setUsername(returnUsername());
            Task createdTask = taskService.addTask(task);
            return ResponseEntity.ok(createdTask);
        }
        return ResponseEntity.badRequest().build();
        
    }

    @PutMapping("/api/task/update")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        if (task != null && task.getToDoDate().compareTo(LocalDate.now())>=0) {
            task.setUsername(returnUsername());
            Task updatedTask = taskService.editTask(task);
            return ResponseEntity.ok(updatedTask);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/api/task/delete/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
