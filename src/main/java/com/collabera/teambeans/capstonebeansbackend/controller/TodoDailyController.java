package com.collabera.teambeans.capstonebeansbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.teambeans.capstonebeansbackend.repository.TodoDailyRepository;

@RestController
@RequestMapping("/daily/")
public class TodoDailyController {

	@Autowired
	private TodoDailyRepository dailyRepo;
	
	
}
