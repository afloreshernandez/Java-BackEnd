package com.collabera.teambeans.capstonebeansbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	@Autowired
	TodoRepository todoRepo;
	
	@GetMapping("/")
	public String getTest() {
		return "itWorks!";
	}
}
