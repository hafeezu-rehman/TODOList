package com.project.todolist.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

@ControllerAdvice
public class GlobalModelAttributeAdvice {

    @Value("${app.api.base-url}")
    private String apiBaseUrl;

    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        model.addAttribute("apiBaseUrl", apiBaseUrl);
    }
}