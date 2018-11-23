package com.example.robot.totest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.robot.totest.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsernameAndPassword(String username, String password);
	
}
