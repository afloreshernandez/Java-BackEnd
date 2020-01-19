package com.collabera.teambeans.capstonebeansbackend;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;
import com.collabera.teambeans.capstonebeansbackend.mysql.types.PriorityLevel;
import com.collabera.teambeans.capstonebeansbackend.mysql.types.Status;

@RestController
public class TodoController {
	@Autowired
	TodoRepository todoRepo;
	
	@GetMapping("/")
	public TodoTask getTest() {
		TodoTask todo = new TodoTask();
		todo.setDescription("Test Desc");
		todo.setDueDate(Date.valueOf(LocalDate.now()));
		todo.setDueTime(Date.valueOf(LocalDate.now()));
		todo.setId(-1L);
		todo.setPriority(PriorityLevel.NORMAL);
		todo.setStatus(Status.PENDING);
		todo.setUser(new UserDetails());
		
		return todo;
	}
	
	
}
