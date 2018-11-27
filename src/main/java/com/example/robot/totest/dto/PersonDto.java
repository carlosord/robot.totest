package com.example.robot.totest.dto;

import com.example.robot.totest.model.Person;
import com.example.robot.totest.model.types.Gender;

/**
 * The Class PersonDto.
 */
public class PersonDto {

	/** The id. */
	private Long id;
	
	/** The dni. */
	private String dni;

	/** The name. */
	private String name;

	/** The last name. */
	private String lastname;

	/** The age. */
	private Integer age;
	
	/** The gender. */
	private String gender;
	
	/** The hascar. */
	private Boolean hascar;
		
	/**
	 * Instantiates a new person dto.
	 */
	public PersonDto() {}
	
	/**
	 * Instantiates a new person dto.
	 *
	 * @param id the id
	 * @param dni            the dni
	 * @param name            the name
	 * @param lastname            the last name
	 * @param age            the age
	 * @param gender the gender
	 * @param hascar the hascar
	 */
	public PersonDto(Long id, String dni, String name, String lastname, Integer age, String gender, Boolean hascar) {
		super();
		this.id = id;
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.hascar = hascar;
	}

	/**
	 * Instantiates a new person dto.
	 *
	 * @param p the p
	 */
	public PersonDto(Person p) {
		this.id = p.getId();
		this.dni = p.getDni();
		this.name = p.getName();
		this.lastname = p.getLastname();
		this.age = p.getAge();
		this.gender = p.getGender() != null ? p.getGender().name() : null;
		this.hascar = p.getHascar();
	}
	
	/**
	 * To model.
	 *
	 * @return the person
	 */
	public Person toModel() {
		Person p = new Person(this.dni);
		p.setId(this.id);
		p.setName(this.name);
		p.setLastname(this.lastname);
		p.setAge(this.age);
		p.setGender(Gender.valueOf(this.gender));
		p.setHascar(this.hascar);
		
		return p;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
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
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the hascar.
	 *
	 * @return the hascar
	 */
	public Boolean getHascar() {
		return hascar;
	}

	/**
	 * Sets the hascar.
	 *
	 * @param hascar the new hascar
	 */
	public void setHascar(Boolean hascar) {
		this.hascar = hascar;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonDto [id=" + id + ", dni=" + dni + ", name=" + name + ", lastname=" + lastname + ", age=" + age
				+ ", gender=" + gender + ", hascar=" + hascar + "]";
	}

}
