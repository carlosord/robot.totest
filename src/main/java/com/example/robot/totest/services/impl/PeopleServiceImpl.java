package com.example.robot.totest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.robot.totest.dto.PersonDto;
import com.example.robot.totest.model.Associations;
import com.example.robot.totest.model.Person;
import com.example.robot.totest.model.User;
import com.example.robot.totest.repositories.PeopleRepository;
import com.example.robot.totest.repositories.UserRepository;
import com.example.robot.totest.services.PeopleService;

/**
 * The Class PeopleServiceImpl.
 */
@Service
public class PeopleServiceImpl implements PeopleService{

	/** The person repository. */
	@Autowired
	private PeopleRepository personRepository;
	
	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see com.example.robot.totest.services.PersonService#findAll()
	 */
	@Override
	public List<PersonDto> findAll() {
		return personRepository.findAll().stream().map(PersonDto::new).collect(Collectors.toList());
	}

	/* (non-Javadoc)
	 * @see com.example.robot.totest.services.PersonService#findByUser(com.example.robot.totest.model.User)
	 */
	@Override
	public List<PersonDto> findByUser(User user) {
		User dbUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		return personRepository.findByUser(dbUser).stream().map(PersonDto::new).collect(Collectors.toList());
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
	public PersonDto save(PersonDto personDto, User user) {
		Person p = personDto.toModel();
		User dbUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		Associations.HasPeople.link(dbUser, p);
		
		return new PersonDto(personRepository.save(p));
	}

	/* (non-Javadoc)
	 * @see com.example.robot.totest.services.PersonService#removeByDni(java.lang.String)
	 */
	@Override
	public void removeByDni(String dni) {
		personRepository.delete(personRepository.findByDni(dni));
	}

}
