package com.collabera.teambeans.capstonebeansbackend.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoTaskController {

	@Autowired
	private TodoRepository todoRepository;

	@GetMapping("/todo")
	public List<TodoTask> retrieveAllTodo(){
		return  todoRepository.findAll();
	}
		
	
}
