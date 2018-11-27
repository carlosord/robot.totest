package com.example.robot.totest.services;

import java.util.List;

import com.example.robot.totest.model.Person;

/**
 * The Interface PersonService.
 */
public interface PersonService {
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Person> findAll();
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the list
	 */
	List<Person> findByUsername(String username);

}
