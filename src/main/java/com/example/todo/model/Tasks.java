package com.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tasks")
public class Tasks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tasks;
	private boolean completed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTasks() {
		return tasks;
	}
	public void setTasks(String tasks) {
		this.tasks = tasks;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public Tasks(int id, String tasks, boolean completed) {
		super();
		this.id = id;
		this.tasks = tasks;
		this.completed = completed;
	}
	@Override
	public String toString() {
		return "Tasks [id=" + id + ", tasks=" + tasks + ", completed=" + completed + "]";
	}
	public Tasks() {
		super();
		// TODO Auto-generated constructor stub
	}
}
