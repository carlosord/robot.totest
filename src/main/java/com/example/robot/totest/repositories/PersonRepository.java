package com.example.robot.totest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.robot.totest.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	public List<Person> findByDni(String dni);

}
