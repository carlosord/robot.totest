package com.example.robot.totest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.robot.totest.model.User;
import com.example.robot.totest.model.types.Role;
import com.example.robot.totest.repositories.UserRepository;
import com.example.robot.totest.services.UserService;

/**
 * The Class UserServiceImpl.
 */
@Service
class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserByCredentials(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public User save(String username, String password) {
		return userRepository.save(new User(username, password, Role.USER));
	}

}
