package com.project.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.todolist.model.User;
import com.project.todolist.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(User user) {
        if(userRepository.findByUsername(user.getUsername())!=null)
        {
            throw new RuntimeException("Username Already Existed");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
    }
    public User findByUserName(String username){
        return userRepository.findByUsername(username);
    }
}
