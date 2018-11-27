package com.example.robot.totest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.robot.totest.model.Person;
import com.example.robot.totest.repositories.PersonRepository;
import com.example.robot.totest.services.PersonService;

/**
 * The Class PersonServiceImpl.
 */
@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public List<Person> findByUsername(String username) {
		String[] name = username.split("-");
		
		return personRepository.findByDniContaining(name[1]);
	}

}
