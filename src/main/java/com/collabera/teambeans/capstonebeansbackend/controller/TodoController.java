package com.collabera.teambeans.capstonebeansbackend.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;
import com.collabera.teambeans.capstonebeansbackend.mysql.types.PriorityLevel;
import com.collabera.teambeans.capstonebeansbackend.mysql.types.Status;
import com.collabera.teambeans.capstonebeansbackend.repository.TodoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {
	@Autowired
	TodoRepository todoRepo;
	
	@GetMapping("/")
	public TodoTask getTest() {
		TodoTask todo = new TodoTask();
		todo.setDescription("Test Desc");
		todo.setDueTime(Date.valueOf(LocalDate.now()));
		todo.setId(-1L);
		todo.setPriority(PriorityLevel.NORMAL);
		todo.setStatus(Status.PENDING);
		todo.setUser(new UserDetails());
		
		return todo;
	}
	
	@GetMapping("/todo")
	public TodoTask getTodo() {
		TodoTask todo = new TodoTask();
		todo.setDescription("Test Desc");
		todo.setDueTime(Date.valueOf(LocalDate.now()));
		todo.setId(-1L);
		todo.setPriority(PriorityLevel.NORMAL);
		todo.setStatus(Status.PENDING);
		todo.setUser(new UserDetails());
		
		return todo;
	}
	
	@GetMapping("/todo/for/{user_id}")
	public List<TodoTask> getTodosForUser(@PathVariable("user_id") Long user_id){
		UserDetails user = new UserDetails();
		user.setUserId(user_id);
		return todoRepo.findByUser(user);
	}
}
