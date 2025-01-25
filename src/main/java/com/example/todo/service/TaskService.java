package com.example.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.Tasks;
import com.example.todo.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository tp;
	
	public Tasks createTask(Tasks task) {
		return tp.save(task);
	}
	
	public List<Tasks> getAllTasks() {
		return tp.findAll();
	}
	
	public void deleteTask(Integer id) {  // Changed Long to Integer
	    Tasks task = tp.getById(id);
	    tp.delete(task);
	}
	
	public List<Tasks> findCompletedTasks(){
		return tp.findCompleted();
	}
	
	public List<Tasks> findInCompletedTasks(){
		return tp.findInComplete();
	}
	
	public Tasks findById(Integer id) {  // Changed Long to Integer
	    return tp.getById(id);
	}
	
	public Tasks update(Tasks task) {
	    return tp.save(task);
	}

}
