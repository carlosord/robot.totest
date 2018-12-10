package com.example.robot.totest.services;

import com.example.robot.totest.model.User;

/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Validate user.
	 *
	 * @param name the name
	 * @param password the password
	 * @return true, if successful
	 */
	User getUserByCredentials(String name, String password);
	
	/**
	 * Save.
	 *
	 * @param username the username
	 * @param password the password
	 */
	User save(String username, String password);

}
