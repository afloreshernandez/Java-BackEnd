package com.collabera.teambeans.capstonebeansbackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;
import com.collabera.teambeans.capstonebeansbackend.repository.TodoRepository;
import com.collabera.teambeans.capstonebeansbackend.repository.UserDetailsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoTaskController {

	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@GetMapping("/todos/{user_id}")
	public List<TodoTask> retrieveUserTodo(@PathVariable("user_id") Long user_id){
		UserDetails user = new UserDetails();
		user.setUserId(user_id);
		return todoRepository.findByUser(user);
	}

	@GetMapping("/todoId/{todo_id}")
	public Optional<TodoTask> getSingleTodoTask(@PathVariable Long todo_id) {
		return todoRepository.findById(todo_id);
	}
	
	// Add todo
	@PostMapping("/todos/{user_id}")
	public ResponseEntity<Object> createTodo(@PathVariable("user_id") Long user_id, @RequestBody TodoTask todoTask) {

	
		Optional<UserDetails> user = userDetailsRepository.findById(user_id);
		
		if(!user.isPresent()) {
			System.out.println("Bad");
			return ResponseEntity.badRequest().build();
		}

		todoTask.setUser(user.get());
		
		TodoTask savedTodo = todoRepository.save(todoTask);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{user_id}")
				.buildAndExpand(savedTodo.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/todos/{todo_id}")
	public void deleteTodo(@PathVariable long todo_id) {
		todoRepository.deleteById(todo_id);
	}

	@PutMapping("/todos/{todo_id}")
	public ResponseEntity<Object> updateTodo(@RequestBody TodoTask todoTask, @PathVariable long todo_id) {

		System.out.println(todoTask);
		
		Optional<TodoTask> todo = todoRepository.findById(todo_id);
		
		if(!todo.isPresent()) {
			System.out.println("Bad");
			return ResponseEntity.badRequest().build();
		}
		todoTask.setId(todo_id);
		todoTask.setUser(todo.get().getUser());
		todoRepository.save(todoTask);
		
		return ResponseEntity.ok().build();
	}
}