package com.collabera.teambeans.capstonebeansbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;

@Repository
public interface TodoRepository extends JpaRepository<TodoTask, Long>{
	
}
