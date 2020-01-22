package com.collabera.teambeans.capstonebeansbackend.unitTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.collabera.teambeans.capstonebeansbackend.controller.TodoTaskController;
import com.collabera.teambeans.capstonebeansbackend.repository.TodoRepository;

@RunWith(MockitoJUnitRunner.class)
public class GetHttpRequestTest {

	private MockMvc mockMvc;

	@Mock
	private TodoRepository todoRepository;


    @Before
    public void setup() {
        final TodoTaskController todoTaskController = new TodoTaskController();

        //notice here I'm setting the mocked dao here
        // if you didn't use @RunWith(MockitoJUnitRunner.class)
        // you can do: todoRepository = Mockito.mock(todoRepository.class);

        todoTaskController.setTodoRepository(todoRepository);

        mockMvc = MockMvcBuilders.standaloneSetup(todoTaskController).build();
    }
	
	
	
	
	@Test
	public void testGetHttpRequest() throws Exception{
		mockMvc.perform(get("/todos/1").contentType("application/json"))
				.andExpect(status().isOk());

		mockMvc.perform(get("/todoId/2").contentType("application/json"))
		.andExpect(status().isOk());
		
//		mockMvc.perform(post("/todos/1").contentType("application/json"))
//		.andExpect(status().isOk());
		
//		mockMvc.perform(delete("/todos/2").contentType("application/json"))
//		.andExpect(status().isOk());
		
//		mockMvc.perform(put("/todos/3").contentType("application/json"))
//		.andExpect(status().isOk());
//		Aside from verifying that the controller responds to a certain URL, this test also 
//		verifies the correct HTTP method (POST in our case) and the correct request 
//		content type. The controller we have seen above would reject any requests
//		with a different HTTP method or content type.

	}
}
