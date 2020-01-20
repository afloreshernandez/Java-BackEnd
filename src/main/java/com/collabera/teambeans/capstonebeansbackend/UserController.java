package com.collabera.teambeans.capstonebeansbackend;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.teambeans.capstonebeansbackend.model.User;
import com.collabera.teambeans.capstonebeansbackend.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;

	//returns all users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	@GetMapping("/users/{userID}")
	public User getUser(@PathVariable ("userID") Long id) {

		Optional<User> found = repository.findById(id);

		if(found.isPresent()) {
			return found.get();
		}
		else {
			return new User();
		}	
	}

	@PostMapping("/users/adduser")
	public void addUser(@RequestBody User user) {
		boolean foundUser = repository.findAll()
				.stream().anyMatch(c -> c.getUserID() == user.getUserID());
		
		if (!foundUser) {
			repository.save(user);
			System.out.print(user + " was saved to the database!");
		}
	} 

	@PutMapping("/users/updateuser")
	public void  updateUser ( @RequestBody User user) {
		Optional <User> optToUpdate = repository.findById(user.getUserID());

		if (optToUpdate.isPresent()) {
			User toUpdate = optToUpdate.get();

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
//
//	//@PatchMapping("user/")
//	public void updateRole(String role, Long id) {
//
//		User userToUpdate = getUser(id);
//
//		if (userToUpdate.getUserID() != -1L) {
//			userToUpdate.setRole(role);
//
//			repository.save(userToUpdate);
//		}			
//	}				
}// ends class