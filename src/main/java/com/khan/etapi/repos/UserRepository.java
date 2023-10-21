package com.khan.etapi.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khan.etapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String User);
}

