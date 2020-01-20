package com.collabera.teambeans.capstonebeansbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.teambeans.capstonebeansbackend.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

}
