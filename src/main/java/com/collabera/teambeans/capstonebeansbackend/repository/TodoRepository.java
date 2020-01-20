package com.collabera.teambeans.capstonebeansbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;
import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;

@Repository
public interface TodoRepository extends JpaRepository<TodoTask, Long>{
<<<<<<< HEAD
	List<TodoTask> findByUser(UserDetails user);
	List<TodoTask> findByUser(@Param("user_id") Long user_id);
=======
	List<TodoTask> findByUser(UserDetails user);
	List<TodoTask> findByUser(long user_id);
>>>>>>> branch 'master' of https://github.com/afloreshernandez/Java-BackEnd
}