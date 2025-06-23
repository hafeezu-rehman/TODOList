package com.project.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.todolist.model.*;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    List<Task> findByUsername(String username);
}
