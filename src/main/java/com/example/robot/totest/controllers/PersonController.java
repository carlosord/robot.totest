package com.example.robot.totest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.robot.totest.dto.PersonDto;
import com.example.robot.totest.model.User;
import com.example.robot.totest.model.types.Role;
import com.example.robot.totest.services.PersonService;

/**
 * The Class PersonController.
 */
@Controller
@SessionAttributes("user")
public class PersonController {

	/** The person service. */
	@Autowired
	private PersonService personService;

	/**
	 * List people.
	 *
	 * @param user the user
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = "/list")
	public String listPeople(@SessionAttribute("user") User user, ModelMap model) {
		
		if (user.getRole() == null) return "login";

		model.put("people", user.getRole().equals(Role.ADMIN) ? personService.findAll()
				: personService.findByUsername(user.getUsername()));

		return "list";
	}

	/**
	 * Show edit view.
	 *
	 * @param model the model
	 * @param dni the dni
	 * @return the string
	 */
	@GetMapping(value = "/edit/{dni}")
	public String showEditView(ModelMap model, @PathVariable(name = "dni") String dni) {

		model.put("person", personService.findByDni(dni));

		return "edit";
	}

	/**
	 * Execute edit view.
	 *
	 * @param user the user
	 * @param model the model
	 * @param personDto the person dto
	 * @return the string
	 */
	@PostMapping(value = "/edit/{dni}")
	public String executeEdit(@SessionAttribute("user") User user, ModelMap model, PersonDto personDto) {
		
		personService.save(personDto);
		
		return "redirect:/list";
	}
	
	/**
	 * Execute delete.
	 *
	 * @param model the model
	 * @param dni the dni
	 * @return the string
	 */
	@GetMapping(value = "/delete/{dni}")
	public String executeDelete(ModelMap model, @PathVariable(name = "dni") String dni) {

		personService.removeByDni(dni);

		return "redirect:/list";
	}
	
	/**
	 * Show new view.
	 *
	 * @param model the model
	 * @param dni the dni
	 * @return the string
	 */
	@GetMapping(value = "/new")
	public String showNewView(ModelMap model) {

		model.put("person", new PersonDto());

		return "new";
	}
	
	/**
	 * Execute edit view.
	 *
	 * @param user the user
	 * @param model the model
	 * @param personDto the person dto
	 * @return the string
	 */
	@PostMapping(value = "/new")
	public String executeNew(@SessionAttribute("user") User user, ModelMap model, PersonDto personDto) {
		
		PersonDto p = personService.findByDni(personDto.getDni());
		
		if (p != null) {
			model.put("errorMessage", "There is a person already declared with the same dni");
			model.put("person", personDto);
			return "/new";
		}
		
		personService.save(personDto);
		
		return "redirect:/list";
	}
	
	@ExceptionHandler({org.springframework.web.bind.ServletRequestBindingException.class})
	public String handler() {
		return "login";
	}

}
