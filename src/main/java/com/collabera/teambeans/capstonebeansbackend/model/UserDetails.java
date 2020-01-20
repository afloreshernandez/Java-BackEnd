package com.collabera.teambeans.capstonebeansbackend.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.FetchMode;

/**
 * 
 * @author Alex
 *
 */
@Entity
@Table(name="user_details")
public class UserDetails {
	@Id
	@Column(name = "user_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	@NotBlank
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String userPassword;
	
	@NotBlank
	private String userRole;
	
	/*
	
	//using user role as enum
	@Enumerated(EnumType.STRING)
	@NotBlank
	private UserRole userRole;
	
	*/

	@OneToMany(mappedBy = "user", targetEntity = TodoTask.class, fetch= FetchType.EAGER, cascade = CascadeType.ALL)
	Set<TodoTask> todoTasks = new HashSet<>();
	
	@OneToMany(mappedBy="user", targetEntity=TodoDaily.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	Set<TodoDaily> todoDailies = new HashSet<>();
	
	public UserDetails() {
		super();
	}

	public UserDetails(Long userId, @NotBlank String firstName, @NotEmpty String lastName, 
			@NotEmpty String userName, @NotEmpty String userPassword, @NotBlank String userRole) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName 
				+ ", userName=" + userName + ", userPassword=" + userPassword + ", userRole=" + userRole
				+ "]";
	}
}