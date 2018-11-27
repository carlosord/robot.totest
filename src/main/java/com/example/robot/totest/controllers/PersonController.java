package com.example.robot.totest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.robot.totest.model.User;
import com.example.robot.totest.model.types.Role;
import com.example.robot.totest.services.PersonService;

@Controller
@SessionAttributes("user")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping(value = "/list")
	public String listPeople(@SessionAttribute("user") User user, ModelMap model) {

		model.put("people", user.getRole().equals(Role.ADMIN) ? personService.findAll()
				: personService.findByUsername(user.getUsername()));

		return "list";

	}

}
