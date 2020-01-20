package com.collabera.teambeans.capstonebeansbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;


public interface UserRepository extends JpaRepository<UserDetails, Long >{

	List<UserDetails> findAll();
	
	// returns one student by their id
	Optional<UserDetails> findById(Long id);
}