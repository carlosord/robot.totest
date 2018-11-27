package com.example.robot.totest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.robot.totest.dto.PersonDto;
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
	public List<PersonDto> findAll() {
		return personRepository.findAll().stream().map(PersonDto::new).collect(Collectors.toList());
	}

	@Override
	public List<PersonDto> findByUsername(String username) {
		String[] name = username.split("-");
		
		return personRepository.findByDniContaining(name[1]).stream().map(PersonDto::new).collect(Collectors.toList());
	}

}
