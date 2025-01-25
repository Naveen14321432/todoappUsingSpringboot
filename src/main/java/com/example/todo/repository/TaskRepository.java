package com.example.todo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.todo.model.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Integer> {
    public List<Tasks> findAll();

    @Query("SELECT t FROM Tasks t WHERE t.completed = true")
    public List<Tasks> findCompleted();

    @Query("SELECT t FROM Tasks t WHERE t.completed = false")
    public List<Tasks> findInComplete();

    public Tasks findByTasks(String task);

    @Override
    public Tasks getById(Integer id);  
}

