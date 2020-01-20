package com.collabera.finalproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.finalproject.model.User;


public interface UserRepository extends JpaRepository<User, Long >{

	List<User> findAll();
	
	// returns one student by their id
	Optional<User> findById(Long id);
}