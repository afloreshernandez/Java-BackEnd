package com.collabera.teambeans.capstonebeansbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.collabera.teambeans.capstonebeansbackend.model.TodoDaily;
import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;

public interface TodoDailyRepository extends JpaRepository<TodoDaily, Long> {
	List<TodoDaily> findByUser(UserDetails user);
	List<TodoDaily> findByUser(Long user_id);
}