package com.collabera.teambeans.capstonebeansbackend.unitTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.collabera.teambeans.capstonebeansbackend.controller.TodoTaskController;
import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;
import com.collabera.teambeans.capstonebeansbackend.repository.TodoRepository;
import com.collabera.teambeans.capstonebeansbackend.repository.UserDetailsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class PostHttpRequestTest {

	private MockMvc mockMvc;

	@Mock
	private TodoRepository todoRepository;
	
	@Mock
	private UserDetailsRepository userDetailsRepository;


    @Before
    public void setup() {
        final TodoTaskController todoTaskController = new TodoTaskController();

        todoTaskController.setTodoRepository(todoRepository);
        todoTaskController.setUserRepository(userDetailsRepository);

        mockMvc = MockMvcBuilders.standaloneSetup(todoTaskController).build();
    }
	

	@Test
	public void testPostHttpRequest() throws Exception{
		
		UserDetails user = new UserDetails();
		user.setUserId(1L);
		
		TodoTask todoTask = new TodoTask();
		todoTask.setUser(user);
		todoTask.setId(17L);
		todoTask.setDescription("Test");
		
		
		
	    mockMvc.perform(post("/todos/1")
	    	       .contentType(MediaType.APPLICATION_JSON)
	    	       .content(asJsonString(todoTask))
	    	       .accept(MediaType.APPLICATION_JSON))
	    	       .andExpect(status().is2xxSuccessful());
	    
		
//		mockMvc.perform(delete("/todos/2").contentType("application/json"))
//		.andExpect(status().isOk());
		
//		mockMvc.perform(put("/todos/3").contentType("application/json"))
//		.andExpect(status().isOk());
//		Aside from verifying that the controller responds to a certain URL, this test also 
//		verifies the correct HTTP method (POST in our case) and the correct request 
//		content type. The controller we have seen above would reject any requests
//		with a different HTTP method or content type.
	    
	    //Means request has succeeded

	}
	
	/*
	public static String asJsonString(final UserDetails user) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(user);
	        
	        System.out.println(jsonContent);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
		
	}
	*/
	
	
	
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
