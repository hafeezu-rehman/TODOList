package com.project.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.todolist.model.*;
@Repository
public interface UserRepository extends JpaRepository<User,String>{
    User findByUsername(String username);
}
