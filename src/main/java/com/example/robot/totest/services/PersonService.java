package com.example.robot.totest.services;

import java.util.List;

import com.example.robot.totest.dto.PersonDto;

/**
 * The Interface PersonService.
 */
public interface PersonService {
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<PersonDto> findAll();
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the list
	 */
	List<PersonDto> findByUsername(String username);

}
