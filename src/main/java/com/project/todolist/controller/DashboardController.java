package com.project.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.todolist.model.User;
import com.project.todolist.model.Task;
import com.project.todolist.service.TaskService;
import com.project.todolist.service.UserService;
@Controller
public class DashboardController {
    @Autowired
    public UserService userService;
    @Autowired
    public TaskService taskService;
    private String returnUsername()
    {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        return username;
    }
    @GetMapping("/dashboard")
    public String displayDashboard(Model model) {
        User user = userService.findByUserName(returnUsername());
        model.addAttribute("name", user.getName());
        return "dashboard";
    }
    @GetMapping("/addtask")
    public String redirectToTaskForm()
    {
        return "addTask";
    }
    @GetMapping("/updatetask/{id}")
    public String redirectToEditForm(@PathVariable Long id, Model model)
    {
        Task task= taskService.findTaskByID(id);
        model.addAttribute("previous", task);
        return "editTask";
    }
}