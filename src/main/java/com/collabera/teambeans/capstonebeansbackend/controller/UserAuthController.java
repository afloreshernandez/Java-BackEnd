package com.collabera.teambeans.capstonebeansbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.teambeans.capstonebeansbackend.bean.UserAuthenticationBean;

public class UserAuthController {

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api/v1")
public class BasicAuthController {

	@GetMapping(path = "/basicauth")
	public UserAuthenticationBean basicauth() {
			return new UserAuthenticationBean("You are authenticated");
		}
	}
}