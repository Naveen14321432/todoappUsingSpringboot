package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.Tasks;
import com.example.todo.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	@Autowired
	private TaskService ts;
	
	@GetMapping("/")
	public ResponseEntity<List<Tasks>> viewAll(){
		return ResponseEntity.ok(ts.getAllTasks());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Tasks> addTask(@RequestBody Tasks task){
		return ResponseEntity.ok(ts.createTask(task));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> viewAll(@PathVariable Integer id) {  // Changed Long to Integer
	    ts.deleteTask(id);
	    return ResponseEntity.ok(true);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tasks> updateTask(@PathVariable Integer id, @RequestBody Tasks task) {  // Changed int to Integer
	    task.setId(id);
	    return ResponseEntity.ok(ts.update(task));
	}
	
	@GetMapping("/completed")
	public ResponseEntity<List<Tasks>> completedTasks(){
		return ResponseEntity.ok(ts.findCompletedTasks());
	}
	
	@GetMapping("/incomplete")
	public ResponseEntity<List<Tasks>> inCompletedTasks(){
		return ResponseEntity.ok(ts.findInCompletedTasks());
	}
	
}
