package com.collabera.teambeans.capstonebeansbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;
import com.collabera.teambeans.capstonebeansbackend.repository.UserDetailsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserDetailsRepository repository;

	//returns all users
	@GetMapping("/users")
	public List<UserDetails> getAllUsers(){
		return repository.findAll();
	}
	@GetMapping("/users/{userID}")
	public EntityModel <UserDetails> getUser(@PathVariable ("userID") Long id) throws Exception {

		Optional<UserDetails> found = repository.findById(id);

		if(!found.isPresent()) 
			throw new Exception("Id not found..");
			
			EntityModel<UserDetails> resource = new EntityModel<UserDetails>(found.get());
			WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
			resource.add(linkTo.withRel("All-users"));

			return resource;
		}	

	@PostMapping("/users/adduser")
	public void addUser(@RequestBody UserDetails user) {
		boolean foundUser = repository.findAll()
				.stream().anyMatch(c -> c.getUserId() == user.getUserId());
		
		if (!foundUser) {
			repository.save(user);
			System.out.print(user + " was saved to the database!");
		}
	} 

	@PutMapping("/users/updateuser")
	public void  updateUser ( @RequestBody UserDetails user) {
		Optional <UserDetails> optToUpdate = repository.findById(user.getUserId());

		if (optToUpdate.isPresent()) {
			UserDetails toUpdate = optToUpdate.get();

			//toUpdate.setUserID(user.getUserID());
			toUpdate.setFirstName(user.getFirstName());
			toUpdate.setLastName(user.getLastName());
			toUpdate.setUserRole(user.getUserRole());
			//toUpdate.setUserName(user.getUserName());
			toUpdate.setUserPassword(user.getUserPassword());

			repository.save(toUpdate);
		}
	}

	@DeleteMapping("/removeuser/{userID}")
	public void deleteUser(@PathVariable ("userID") Long id) {
		repository.deleteById((long) id);
	}

//	//@PatchMapping("/updateuser/password/{}")
//	public void updatePassword(String password, Long id){
//
//		User userToUpdate = getUser(id);
//
//		if (userToUpdate.getUserID() != -1L) {
//			userToUpdate.setPassword(password);
//			repository.save(userToUpdate);
//		}
//	}
	
	
	
	@PatchMapping("/user/{userId}")
	public EntityModel<UserDetails> updateRole(@PathVariable Long userId, String userRole) {

		UserDetails userToUpdate = repository.findById(userId).get();

		if (userToUpdate.getUserId() != -1L) {
			userToUpdate.setUserRole(userRole);

			repository.save(userToUpdate);
		}	
		
		EntityModel<UserDetails> resource = new EntityModel<UserDetails>(userToUpdate);
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("http://localhost:8080"));
		
		return resource;
	}
	
}// ends class