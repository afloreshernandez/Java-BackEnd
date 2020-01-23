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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.WebApplicationContext;

import com.collabera.teambeans.capstonebeansbackend.controller.TodoTaskController;
import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.repository.TodoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestDelete_Todo {
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

		assert(todoRepository.findById(6L).isPresent());
		
		todoTaskController.deleteTodo(6);
		
		Optional<TodoTask> testTodo = todoRepository.findById(6L);
		
		assert (!testTodo.isPresent());
	}
}
