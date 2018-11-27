package com.example.robot.totest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.robot.totest.model.User;
import com.example.robot.totest.services.UserService;

/**
 * The Class LoginController.
 */
@Controller
@SessionAttributes("user")
public class LoginController {

	/** The user service. */
	@Autowired
	private UserService userService;
	
	/**
	 * Show welcome page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = "/")
	public String showWelcomePage(ModelMap model) {
		return "welcome";
	}
	
	/**
	 * Show login page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = "/login")
	public String showLoginPage(ModelMap model) {
		return "login";
	}

	/**
	 * Sets the up user form.
	 *
	 * @return the user
	 */
	@ModelAttribute("user")
	public User setUpUserForm() {
		return new User();
	}

	/**
	 * Showlist page.
	 *
	 * @param user the user
	 * @param model the model
	 * @return the string
	 */
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

	/**
	 * Show register page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = "/register")
	public String showRegisterPage(ModelMap model) {
		return "register";
	}

	/**
	 * Register new user.
	 *
	 * @param user the user
	 * @param model the model
	 * @return the string
	 */
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
	
	/**
	 * Logout user.
	 *
	 * @param user the user
	 * @param model the model
	 * @return the string
	 */
	@PostMapping(value = "/logout")
	public String logoutUser(@SessionAttribute("user") User user, ModelMap model) {
		user = null;
		return "login";
	}

}