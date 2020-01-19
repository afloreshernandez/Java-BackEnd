package com.collabera.teambeans.capstonebeansbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserDetails {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	public UserDetails() {
		super();
	}

	public UserDetails(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}
	
}
