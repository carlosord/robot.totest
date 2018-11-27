package com.example.robot.totest.dto;

import com.example.robot.totest.model.Person;

/**
 * The Class PersonDto.
 */
public class PersonDto {

	/** The dni. */
	private String dni;

	/** The name. */
	private String name;

	/** The last name. */
	private String lastName;

	/** The age. */
	private Integer age;

	/**
	 * Instantiates a new person dto.
	 *
	 * @param dni
	 *            the dni
	 * @param name
	 *            the name
	 * @param lastName
	 *            the last name
	 * @param age
	 *            the age
	 */
	public PersonDto(String dni, String name, String lastName, Integer age) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public PersonDto(Person p) {
		this.dni = p.getDni();
		this.name = p.getName();
		this.lastName = p.getLastname();
		this.age = p.getAge();
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni
	 *            the new dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age
	 *            the new age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonDto [dni=" + dni + ", name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}

}
