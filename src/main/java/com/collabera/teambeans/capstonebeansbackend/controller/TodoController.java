package com.collabera.teambeans.capstonebeansbackend.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public EntityModel<TodoTask> getTest() {
		TodoTask todo = new TodoTask();
		todo.setDescription("Test Desc");
		//todo.setDueTime(Date.valueOf(LocalDate.now()));
		todo.setId(-1L);
		todo.setPriority(PriorityLevel.NORMAL);
		todo.setStatus(Status.PENDING);
		todo.setUser(new UserDetails());
		
		return new EntityModel<>(todo,new Link("https:/localhost:8080/todos"));
	}
	
	@GetMapping("/todo")
	public TodoTask getTodo() {
		TodoTask todo = new TodoTask();
		todo.setDescription("Test Desc");
		//todo.setDueTime(Date.valueOf(LocalDate.now()));
		todo.setId(-1L);
		todo.setPriority(PriorityLevel.NORMAL);
		todo.setStatus(Status.PENDING);
		todo.setUser(new UserDetails());
		
		return todo;
	}
	
	@GetMapping("/todo/{user_id}")
	public List<TodoTask> getTodosForUser(@PathVariable("user_id") Long user_id){
		UserDetails user = new UserDetails();
		user.setUserId(user_id);
		return todoRepo.findByUser(user);
	}
	
	@PostMapping("/todo/{user_id}")
	public TodoTask postTodo(@RequestBody TodoTask todo, @PathVariable("user_id") long userId) {
		
		System.out.println(todo);
		
		if(todo.getUser()==null)
			todo.setUser(new UserDetails());
		

		todo.getUser().setUserId(userId);
		System.out.println(todo.getUser());
		
		todo = todoRepo.save(todo);
		return todo;
	}
}