package com.example.robot.totest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.robot.totest.model.Person;

/**
 * The Interface PersonRepository.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	/**
	 * Find by dni.
	 *
	 * @param dni the dni
	 * @return the list
	 */
	public List<Person> findByDni(String dni);

	/**
	 * Find by dni containing.
	 *
	 * @param string the string
	 * @return the list
	 */
	public List<Person> findByDniContaining(String string);

}
