package com.example.robot.totest.services;

import java.util.List;

import com.example.robot.totest.dto.PersonDto;

/**
 * The Interface PeopleService.
 */
public interface PeopleService {
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<PersonDto> findAll();
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the list
	 */
	public List<PersonDto> findByUsername(String username);

	/**
	 * Find by dni.
	 *
	 * @param dni the dni
	 * @return the person dto
	 */
	public PersonDto findByDni(String dni);

	/**
	 * Save.
	 *
	 * @param personDto the person dto
	 * @return the person
	 */
	public PersonDto save(PersonDto personDto);

	/**
	 * Removes the by dni.
	 *
	 * @param dni the dni
	 */
	public void removeByDni(String dni);

}
