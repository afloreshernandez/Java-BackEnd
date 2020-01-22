package com.collabera.teambeans.capstonebeansbackend.unitTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.collabera.teambeans.capstonebeansbackend.controller.TodoTaskController;
import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;
import com.collabera.teambeans.capstonebeansbackend.repository.TodoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class PutHttpRequestTest {

	private MockMvc mockMvc;

	@Mock
	private TodoRepository todoRepository;


	@Before
	public void setup() {
		final TodoTaskController todoTaskController = new TodoTaskController();

		todoTaskController.setTodoRepository(todoRepository);

		mockMvc = MockMvcBuilders.standaloneSetup(todoTaskController).build();
	}

	@Test
	public void testGetHttpRequest() throws Exception{
		
		UserDetails user = new UserDetails();
		user.setUserId(1L);
		
		TodoTask todoTask = new TodoTask();
		todoTask.setUser(user);
		todoTask.setId(15L);
		
		
		
		mockMvc.perform(put("/todos/15")
				.contentType("application/json")
				.content(asJsonString(todoTask))
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().is2xxSuccessful());

	}
	
	
	
	public static String asJsonString(final TodoTask todoTask) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(todoTask);
	        
	        System.out.println(jsonContent);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
		
	}
	
	
}