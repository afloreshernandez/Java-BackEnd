package com.collabera.teambeans.capstonebeansbackend.model;

import java.util.Date;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.collabera.teambeans.capstonebeansbackend.mysql.types.PriorityLevel;
import com.collabera.teambeans.capstonebeansbackend.mysql.types.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Stefan Sternberg
 * @date 2020-01-18
 */
@Entity
public class TodoDaily{
	
	@Id
	@Column(name="todo_daily_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String description;

	@NotBlank
	@Enumerated(EnumType.STRING)
	private PriorityLevel priority;

	@NotBlank
	@Enumerated(EnumType.STRING)
	private Status status;	

	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetails user;

	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private Date dueTime;


	/**
	 * Constructs a new To Do task with no information. This is really only here for use by spring beans.
	 */
	public TodoDaily() {
	}

	/**
	 * Constructs a new To Do task with the given information.
	 * @param id
	 * @param balance
	 * @param type
	 */
	public TodoDaily(Long id, @NotBlank String description, @NotBlank Status status, @NotBlank PriorityLevel priority, @NotNull Date time) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.priority = priority;
		//this.dueTime = dueTime;
	}
	/**
	 * 
	 * @return this todotask's id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return this todotask's description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 
	 * @return this todotask's priority level
	 */
	public PriorityLevel getPriority() {
		return priority;
	}
	/**
	 * 
	 * @param priority
	 */
	public void setPriority(PriorityLevel priority) {
		this.priority = priority;
	}
	/**
	 * 
	 * @return this todotask's completion status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * 
	 * @param status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * 
	 * @return this todotask's user
	 */
	public UserDetails getUser() {
		return user;
	}
	/**
	 * 
	 * @param user
	 */
	public void setUser(UserDetails user) {
		this.user = user;
	}
	/**
	 * 
	 * @return
	 */
	public Date getDueTime() {
		return dueTime;
	}

	/**
	 * 
	 * @param dueTime
	 */
	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}

	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "TodoDaily [id=" + id + ", description=" + description + ", priority=" + priority + ", status=" + status
				+ "]";
	}
}






//package com.collabera.teambeans.capstonebeansbackend.model;
//
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//
//import com.collabera.teambeans.capstonebeansbackend.mysql.types.PriorityLevel;
//import com.collabera.teambeans.capstonebeansbackend.mysql.types.Status;
//
///**
// * 
// * @author Stefan Sternberg
// * @date 2020-01-18
// */
//@Entity
//public class TodoDaily{
//	
//	@Id
//	@Column(name="todo_daily_id")
//	@GeneratedValue(strategy= GenerationType.AUTO)
//	private Long id;
//
//	@NotBlank
//	private String description;
//
//	@NotBlank
//	@Enumerated(EnumType.STRING)
//	private PriorityLevel priority;
//
//	@NotBlank
//	@Enumerated(EnumType.STRING)
//	private Status status;	
//
//	/*
//	@ManyToOne
//	@JoinColumn(name="user_id", referencedColumnName = "id")
//	private User user;
//	*/
//	
//	/*
//	@Temporal(TemporalType.TIME)
//<<<<<<< HEAD
//	private LocalTime dueTime;
//	*/
//=======
//	private Date dueTime;
//>>>>>>> origin/master
//
//	/**
//	 * Constructs a new To Do task with no information. This is really only here for use by spring beans.
//	 */
//	public TodoDaily() {
//	}
//
//	/**
//	 * Constructs a new To Do task with the given information.
//	 * @param id
//	 * @param balance
//	 * @param type
//	 */
//	public TodoDaily(Long id, @NotBlank String description, @NotBlank Status status, @NotBlank PriorityLevel priority, @NotNull Date time) {
//		super();
//		this.id = id;
//		this.description = description;
//		this.status = status;
//		this.priority = priority;
//		//this.dueTime = dueTime;
//	}
//	/**
//	 * 
//	 * @return this todotask's id
//	 */
//	public Long getId() {
//		return id;
//	}
//	/**
//	 * 
//	 * @param id
//	 */
//	public void setId(Long id) {
//		this.id = id;
//	}
//	/**
//	 * 
//	 * @return this todotask's description
//	 */
//	public String getDescription() {
//		return description;
//	}
//	/**
//	 * 
//	 * @param description
//	 */
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	/**
//	 * 
//	 * @return this todotask's priority level
//	 */
//	public PriorityLevel getPriority() {
//		return priority;
//	}
//	/**
//	 * 
//	 * @param priority
//	 */
//	public void setPriority(PriorityLevel priority) {
//		this.priority = priority;
//	}
//	/**
//	 * 
//	 * @return this todotask's completion status
//	 */
//	public Status getStatus() {
//		return status;
//	}
//	/**
//	 * 
//	 * @param status
//	 */
//	public void setStatus(Status status) {
//		this.status = status;
//	}
//
//	/*
//	public User getUser() {
//		return user;
//	}
//	
//	public void setUser(User user) {
//		this.user = user;
//	}
//<<<<<<< HEAD
//	*/
//	
//	/*
//
//	public LocalTime getDueTime() {
//		return dueTime;
//	}
//
//
//	public void setDueTime(LocalTime dueTime) {
//=======
//	/**
//	 * 
//	 * @return
//	 */
//	public Date getDueTime() {
//		return dueTime;
//	}
//
//	/**
//	 * 
//	 * @param dueTime
//	 */
//	public void setDueTime(Date dueTime) {
//>>>>>>> origin/master
//		this.dueTime = dueTime;
//	}
//
//	
//	/**
//	 * 
//	 */
//	@Override
//	public String toString() {
//		return "TodoDaily [id=" + id + ", description=" + description + ", priority=" + priority + ", status=" + status
//				+ "]";
//	}
//}
//
//
//
//
//

//package com.collabera.teambeans.capstonebeansbackend.model;
//
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//
//import com.collabera.teambeans.capstonebeansbackend.mysql.types.PriorityLevel;
//import com.collabera.teambeans.capstonebeansbackend.mysql.types.Status;
//
///**
// * 
// * @author Stefan Sternberg
// * @date 2020-01-18
// */
//@Entity
//public class TodoDaily{
//	
//	@Id
//	@Column(name="todo_daily_id")
//	@GeneratedValue(strategy= GenerationType.AUTO)
//	private Long id;
//
//	@NotBlank
//	private String description;
//
//	@NotBlank
//	@Enumerated(EnumType.STRING)
//	private PriorityLevel priority;
//
//	@NotBlank
//	@Enumerated(EnumType.STRING)
//	private Status status;	
//
//	@ManyToOne
//	@JoinColumn(name="user_id", referencedColumnName = "user_id")
//	private UserDetails user;
//
//	@Temporal(TemporalType.TIME)
//	private Date dueTime;
//
//
//	/**
//	 * Constructs a new To Do task with no information. This is really only here for use by spring beans.
//	 */
//	public TodoDaily() {
//	}
//
//	/**
//	 * Constructs a new To Do task with the given information.
//	 * @param id
//	 * @param balance
//	 * @param type
//	 */
//	public TodoDaily(Long id, @NotBlank String description, @NotBlank Status status, @NotBlank PriorityLevel priority, @NotNull Date time) {
//		super();
//		this.id = id;
//		this.description = description;
//		this.status = status;
//		this.priority = priority;
//		//this.dueTime = dueTime;
//	}
//	/**
//	 * 
//	 * @return this todotask's id
//	 */
//	public Long getId() {
//		return id;
//	}
//	/**
//	 * 
//	 * @param id
//	 */
//	public void setId(Long id) {
//		this.id = id;
//	}
//	/**
//	 * 
//	 * @return this todotask's description
//	 */
//	public String getDescription() {
//		return description;
//	}
//	/**
//	 * 
//	 * @param description
//	 */
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	/**
//	 * 
//	 * @return this todotask's priority level
//	 */
//	public PriorityLevel getPriority() {
//		return priority;
//	}
//	/**
//	 * 
//	 * @param priority
//	 */
//	public void setPriority(PriorityLevel priority) {
//		this.priority = priority;
//	}
//	/**
//	 * 
//	 * @return this todotask's completion status
//	 */
//	public Status getStatus() {
//		return status;
//	}
//	/**
//	 * 
//	 * @param status
//	 */
//	public void setStatus(Status status) {
//		this.status = status;
//	}
//	/**
//	 * 
//	 * @return this todotask's user
//	 */
//	public UserDetails getUser() {
//		return user;
//	}
//	/**
//	 * 
//	 * @param user
//	 */
//	public void setUser(UserDetails user) {
//		this.user = user;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	public Date getDueTime() {
//		return dueTime;
//	}
//
//	/**
//	 * 
//	 * @param dueTime
//	 */
//	public void setDueTime(Date dueTime) {
//		this.dueTime = dueTime;
//	}
//
//	
//	/**
//	 * 
//	 */
//	@Override
//	public String toString() {
//		return "TodoDaily [id=" + id + ", description=" + description + ", priority=" + priority + ", status=" + status
//				+ "]";
//	}
//}

