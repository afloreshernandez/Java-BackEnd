package com.collabera.teambeans.capstonebeansbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.teambeans.capstonebeansbackend.model.TodoDaily;
import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;
import com.collabera.teambeans.capstonebeansbackend.repository.TodoDailyRepository;

@RestController
@RequestMapping("/daily")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoDailyController {

	@Autowired
	private TodoDailyRepository dailyRepo;
	
	@GetMapping("/{user_id}")
	public List<TodoDaily> getDailies(@PathVariable("user_id") Long user_id) {
		UserDetails user = new UserDetails();
		user.setUserId(user_id);
		return dailyRepo.findByUser(user);
	}
	
	@PostMapping("/{user_id}")
	public TodoDaily postDaily(@PathVariable("user_id") long user_id, @RequestBody TodoDaily daily) {
		
		System.out.println(daily);
		
		if(daily.getUser()==null)
			daily.setUser(new UserDetails());
		

		daily.getUser().setUserId(user_id);
		System.out.println(daily.getUser());
		
		daily = dailyRepo.save(daily);
		return daily;
	}
}
