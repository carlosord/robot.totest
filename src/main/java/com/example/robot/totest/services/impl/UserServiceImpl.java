package com.example.robot.totest.services.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.robot.totest.model.Associations;
import com.example.robot.totest.model.Person;
import com.example.robot.totest.model.User;
import com.example.robot.totest.model.types.Gender;
import com.example.robot.totest.model.types.Role;
import com.example.robot.totest.repositories.PeopleRepository;
import com.example.robot.totest.repositories.UserRepository;
import com.example.robot.totest.services.UserService;

/**
 * The Class UserServiceImpl.
 */
@Service
class UserServiceImpl implements UserService {
	
	/** The Constant MAX_PEOPLE. */
	private static final Integer MAX_PEOPLE = 10;
	
	/** The Constant INITIAL_PERSON_AGE. */
	private static final Integer INITIAL_PERSON_AGE = 20;
	
	/** The Constant PERSON_PREFIX. */
	private static final String PERSON_PREFIX = "User";
	
	/** The Constant INITIAL_DNI. */
	private static final Integer INITIAL_DNI = 10000000;
	
	/** The Constant LAST_DNI. */
	private static final Integer LAST_DNI = 10000000;
	
	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/** The people repository. */
	@Autowired
	private PeopleRepository peopleRepository;

	/* (non-Javadoc)
	 * @see com.example.robot.totest.services.UserService#getUserByCredentials(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUserByCredentials(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	/* (non-Javadoc)
	 * @see com.example.robot.totest.services.UserService#save(java.lang.String, java.lang.String)
	 */
	@Override
	public User save(String username, String password) {
		
		User user = userRepository.save(new User(username, password, Role.USER));
		
		// Add people to user
		for (int i = 1; i < MAX_PEOPLE; i++) {
			
			// Generates a random letter
			char dniChar = (char)((int)'A' + Math.random() * ((int)'Z' - (int)'A'+1));
			// Generates a random number
			int dniNumber = new Random(System.currentTimeMillis()).nextInt(LAST_DNI) + INITIAL_DNI;
			
			Person p = new Person(dniNumber + String.valueOf(dniChar));
			p.setAge(INITIAL_PERSON_AGE + i);
			p.setName(PERSON_PREFIX + i);
			p.setLastname(PERSON_PREFIX + i);
			p.setGender(Gender.getRandomGender());
			p.setHascar(new Random().nextBoolean());
			
			Associations.HasPeople.link(user, p);
			
			peopleRepository.save(p);
			
		}
		
		return user;
	}

}
