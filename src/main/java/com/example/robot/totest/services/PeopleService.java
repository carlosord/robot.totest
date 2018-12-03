package com.example.robot.totest.services;

import java.util.List;

import com.example.robot.totest.dto.PersonDto;
import com.example.robot.totest.model.User;

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
	 * Find by user.
	 *
	 * @param user the user
	 * @return the list
	 */
	public List<PersonDto> findByUser(User user);

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
