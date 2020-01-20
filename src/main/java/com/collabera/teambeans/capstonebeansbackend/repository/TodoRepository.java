package com.collabera.teambeans.capstonebeansbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;

@Repository
public interface TodoRepository extends JpaRepository<TodoTask, Long>{
	List<TodoTask> findByUser(UserDetails user);
	List<TodoTask> findByUser(Long user_id);
}
