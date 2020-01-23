package com.collabera.teambeans.capstonebeansbackend.unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.collabera.teambeans.capstonebeansbackend.controller.TodoTaskController;
import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.repository.TodoRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestGetUser_Todo {
	private MockMvc mvc;

	@Autowired
	TodoTaskController todoTaskController;
	
	@Autowired
	TodoRepository todoRepository;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	

	@Test
	public void test() throws Exception{

		Optional<TodoTask> todo = todoTaskController.getSingleTodoTask(1L);
		
		Optional<TodoTask> testTodo = todoRepository.findById(1L);
		
		System.out.println(todo + "\n" + testTodo);
		
		assertEquals(todo.get().getId(), testTodo.get().getId());
		assertEquals(todo.get().getDescription(), testTodo.get().getDescription());
		assertEquals(todo.get().getDueDate(), testTodo.get().getDueDate());
		assertEquals(todo.get().getDueTime(), testTodo.get().getDueTime());
		assertEquals(todo.get().getPriority(), testTodo.get().getPriority());
		assertEquals(todo.get().getStatus(), testTodo.get().getStatus());
		assertEquals(todo.get().getUser().getFirstName(), testTodo.get().getUser().getFirstName());
		assertEquals(todo.get().getUser().getUserId(), testTodo.get().getUser().getUserId());
		assertEquals(todo.get().getUser().getFirstName(), testTodo.get().getUser().getFirstName());
		assertEquals(todo.get().getUser().getUserName(), testTodo.get().getUser().getUserName());
		assertEquals(todo.get().getUser().getUserPassword(), testTodo.get().getUser().getUserPassword());
		assertEquals(todo.get().getUser().getLastName(), testTodo.get().getUser().getLastName());
		assertEquals(todo.get().getUser().getUserRole(), testTodo.get().getUser().getUserRole());
	}
}




