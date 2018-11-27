package com.example.robot.totest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.robot.totest.model.User;
import com.example.robot.totest.services.UserService;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/login")
	public String showLoginPage(ModelMap model) {
		return "login";
	}

	@ModelAttribute("user")
	public User setUpUserForm() {
		return new User();
	}

	@PostMapping(value = "/login")
	public String showlistPage(@ModelAttribute("user") User user, ModelMap model) {

		User findedUser = userService.getUserByCredentials(user.getUsername(), user.getPassword());

		if (findedUser == null) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}

		user.setRole(findedUser.getRole());
		
		return "welcome";
	}

	@GetMapping(value = "/register")
	public String showRegisterPage(ModelMap model) {
		return "register";
	}

	@PostMapping(value = "/register")
	public String registerNewUser(@ModelAttribute("user") User user, ModelMap model) {

		User registerUser = userService.getUserByCredentials(user.getUsername(), user.getPassword());

		if (registerUser != null) {
			model.put("errorMessage", "User already registered");
			return "register";
		}

		user.setRole(userService.save(user.getUsername(), user.getPassword()).getRole());

		return "welcome";
	}

}