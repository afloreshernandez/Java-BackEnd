package com.collabera.teambeans.capstonebeansbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.repository.TodoRepository;

@RestController
public class TodoTaskController {

	@Autowired
	private TodoRepository todoRepository;

	@GetMapping("/todotask")
	public List<TodoTask> retrieveAllTodo(){
		return  todoRepository.findAll();
	}
}
