package com.collabera.teambeans.capstonebeansbackend.unitTests;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.collabera.teambeans.capstonebeansbackend.controller.TodoTaskController;
import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;
import com.collabera.teambeans.capstonebeansbackend.repository.TodoRepository;



public class MockitoTodoTaskControllerTest {

	@InjectMocks
	private TodoTaskController todoTaskController = new TodoTaskController();

	@Mock
	private TodoRepository todoRepository;

	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetrieveUserTodo() {

		
		//List<TodoTask> testList = new ArrayList<TodoTask>();
		//List<TodoTask> testList = null;

		//Mockito.when(todoRepository.findByUser(1L)).thenReturn(testList);

		//List<TodoTask> userList = todoTaskController.retrieveUserTodo(1L);
		List<TodoTask> userList = null;




		UserDetails user = new UserDetails();
		user.setUserId(1L);
		
		List<TodoTask> testList = todoRepository.findByUser(user);
		
		System.out.println(testList + "; " + userList);


		//Mockito.verify(todoRepository).findByUser(user);

		//assertEquals(testList., userList);

	}



}

