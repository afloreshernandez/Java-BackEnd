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
public class DeleteHttpRequestTest {

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
		mockMvc.perform(delete("/todos/3").contentType("application/json"))
				.andExpect(status().isOk());

	}
}
