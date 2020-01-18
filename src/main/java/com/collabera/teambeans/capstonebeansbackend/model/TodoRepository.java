package com.collabera.teambeans.capstonebeansbackend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoTask, Long>{
	
}
