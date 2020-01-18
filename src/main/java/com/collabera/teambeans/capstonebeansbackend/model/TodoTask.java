package com.collabera.teambeans.capstonebeansbackend.model;

import java.sql.Date;
import java.time.LocalTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.collabera.teambeans.capstonebeansbackend.mysql.types.PriorityLevel;

import javax.validation.constraints.NotBlank;


@Entity
public class TodoTask{
	
	@Id
	@Column(name="todo_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String description;

	@NotBlank
	@Enumerated(EnumType.String)
	private PriorityLevel priority;

	@NotBlank
	@Enumerated(EnumType.STRING)
	private Status status;	

	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName = "id")
	private User user;

	@Temporal(TemporalType.DATE)
	private Date dueDate;

	@Temporal(TemporalType.TIME)
	private LocalTime dueTime;

	/**
	 * Constructs a new To Do task with no information. This is really only here for use by spring beans.
	 */
	public TodoTask() {
		this(-1L, "N/A", Status.PENDING, PriorityLevel.NORMAL, Calendar.);
	}

	/**
	 * Constructs a new To Do task with the given information.
	 * @param id
	 * @param balance
	 * @param type
	 */
	public TodoTask(Long id, @NotBlank String description, @NotBlank Status status, @NotBlank PriorityLevel priority, @NotNull Date dueDate, @NotNull LocalTime time) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.priority = priority;
	}
}




