package com.collabera.teambeans.capstonebeansbackend;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.teambeans.capstonebeansbackend.model.TodoTask;

public interface TodoRepository extends JpaRepository<TodoTask, Long> {

}
