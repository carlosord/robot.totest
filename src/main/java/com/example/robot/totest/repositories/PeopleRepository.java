package com.example.robot.totest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.robot.totest.model.Person;

/**
 * The Interface PeopleRepository.
 */
@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {
	
	/**
	 * Find by dni containing.
	 *
	 * @param dni the dni
	 * @return the list
	 */
	public List<Person> findByDniContaining(String dni);
	
	/**
	 * Find by dni.
	 *
	 * @param dni the dni
	 * @return the person
	 */
	public Person findByDni(String dni);

}
