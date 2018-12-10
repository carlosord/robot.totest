package com.example.robot.totest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.robot.totest.model.User;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Find by username and password.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the user
	 */
	public User findByUsernameAndPassword(String username, String password);
	
}
