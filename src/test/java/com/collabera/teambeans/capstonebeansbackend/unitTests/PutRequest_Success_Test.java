package com.collabera.teambeans.capstonebeansbackend.unitTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.collabera.teambeans.capstonebeansbackend.controller.TodoTaskController;
import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;
import com.collabera.teambeans.capstonebeansbackend.repository.TodoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PutRequest_Success_Test {
	private MockMvc mvc;

	@Autowired
	TodoTaskController todoTaskController;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPut() throws Exception{
		
		UserDetails user = new UserDetails();
		user.setUserId(1L);
		
		TodoTask todoTask = new TodoTask();
		todoTask.setUser(user);
		todoTask.setId(8L);
		todoTask.setDescription("NotNull");
		
		
		
		mvc.perform(put("/todos/{todo_id}", 8)
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