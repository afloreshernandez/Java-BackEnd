package com.collabera.teambeans.capstonebeansbackend.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoTask, Long>{
	List<TodoTask> findByUser(UserDetails user);
	List<TodoTask> findByUser(long user_id);
}
