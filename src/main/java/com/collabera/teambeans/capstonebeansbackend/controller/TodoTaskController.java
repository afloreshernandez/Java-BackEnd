package com.collabera.teambeans.capstonebeansbackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.collabera.teambeans.capstonebeansbackend.controller.exceptions.TodoTaskNotFoundException;
import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.repository.TodoRepository;

@RestController
public class TodoTaskController {

	@Autowired
	private TodoRepository todoRepository;

	@GetMapping("/todos")
	public List<TodoTask> retrieveAllTodo(){
		return  todoRepository.findAll();
	}
	
	
	@GetMapping("/todos/{id}")
	public EntityModel<TodoTask> retrieveTodo(@PathVariable long id) {
	    Optional<TodoTask> todo = todoRepository.findById(id);
	    if (!todo.isPresent())
	      throw new TodoTaskNotFoundException("id-" + id);
	    EntityModel<TodoTask> resource = new EntityModel<TodoTask>(todo.get());
	    WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllTodo());
	    resource.add(linkTo.withRel("all-students"));
	    return resource;	
	}
	
	
	  @DeleteMapping("/todos/{id}")
	  public void deleteStudent(@PathVariable long id) {
	    todoRepository.deleteById(id);
	  }
	  
	  @PostMapping("/students")
	  public ResponseEntity<Object> createStudent(@RequestBody TodoTask todoTask) {
	    TodoTask savedTodo = todoRepository.save(todoTask);
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	        .buildAndExpand(savedTodo.getId()).toUri();
	    return ResponseEntity.created(location).build();
	  }
	  
	  @PutMapping("/students/{id}")
	  public ResponseEntity<Object> updateStudent(@RequestBody TodoTask todoTask, @PathVariable long id) {
	    Optional<TodoTask> todoOptional = todoRepository.findById(id);
	    if (!todoOptional.isPresent())
	      return ResponseEntity.notFound().build();
	    todoTask.setId(id);
	    todoRepository.save(todoTask);
	    return ResponseEntity.noContent().build();
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


