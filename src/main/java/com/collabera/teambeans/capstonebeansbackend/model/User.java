package com.collabera.finalproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="userTable")
public class User implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "user_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userID;
	
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
	
	public User(Long userID, @NotBlank String firstName, @NotEmpty String lastName, @NotBlank String role, @NotEmpty String userName, @NotEmpty String password) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = role;
		this.userName = userName;
		this.userPassword = password;
	}
	
	public User() {
	};
	
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
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
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String role) {
		this.userRole = role;
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

	public void setUserPassword(String password) {
		this.userPassword = password;
	}
}