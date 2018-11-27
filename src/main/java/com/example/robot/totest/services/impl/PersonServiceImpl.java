package com.example.robot.totest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.robot.totest.dto.PersonDto;
import com.example.robot.totest.model.Person;
import com.example.robot.totest.repositories.PersonRepository;
import com.example.robot.totest.services.PersonService;

/**
 * The Class PersonServiceImpl.
 */
@Service
public class PersonServiceImpl implements PersonService{

	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;
	
	/* (non-Javadoc)
	 * @see com.example.robot.totest.services.PersonService#findAll()
	 */
	@Override
	public List<PersonDto> findAll() {
		return personRepository.findAll().stream().map(PersonDto::new).collect(Collectors.toList());
	}

	/* (non-Javadoc)
	 * @see com.example.robot.totest.services.PersonService#findByUsername(java.lang.String)
	 */
	@Override
	public List<PersonDto> findByUsername(String username) {
		String[] name = username.split("-");
		
		return personRepository.findByDniContaining(name[1]).stream().map(PersonDto::new).collect(Collectors.toList());
	}

	/* (non-Javadoc)
	 * @see com.example.robot.totest.services.PersonService#findByDni(java.lang.String)
	 */
	@Override
	public PersonDto findByDni(String dni) {
		Person p = personRepository.findByDni(dni);
		return p != null ? new PersonDto(p) : null;
	}

	/* (non-Javadoc)
	 * @see com.example.robot.totest.services.PersonService#save(com.example.robot.totest.dto.PersonDto)
	 */
	@Override
	public PersonDto save(PersonDto personDto) {
		return new PersonDto(personRepository.save(personDto.toModel()));
	}

	/* (non-Javadoc)
	 * @see com.example.robot.totest.services.PersonService#removeByDni(java.lang.String)
	 */
	@Override
	public void removeByDni(String dni) {
		personRepository.delete(personRepository.findByDni(dni));
	}

}
