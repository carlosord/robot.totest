package com.example.robot.totest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.robot.totest.model.types.Role;

/**
 * The Class User.
 */
@Entity
@Table(name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = { "username" }))
public class User extends BaseEntity {

	/** The username. */
	@NotEmpty
	@Column(name = "username", nullable = false)
	private String username;

	/** The password. */
	@NotEmpty
	@Column(name = "password", nullable = false)
	private String password;

	/** The role. */
	@NotNull
	@Column(name = "role", nullable = false)
	private Role role;

	/** The people. */
	@OneToMany(mappedBy = "user")
	private Set<Person> people = new HashSet<>();

	/**
	 * Instantiates a new user.
	 */
	public User() {
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @param role
	 *            the role
	 */
	public User(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role
	 *            the new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", role=" + role + "]";
	}

	// Maintenance relations

	/**
	 * Gets the people.
	 *
	 * @return the people
	 */
	public Set<Person> getPeople() {
		return new HashSet<>(this.people);
	}

	/**
	 * Sets the people.
	 *
	 * @param people
	 *            the new people
	 */
	public void setPeople(Set<Person> people) {
		this.people = people;
	}

	/**
	 * Adds the person.
	 *
	 * @param person
	 *            the person
	 */
	public void addPerson(Person person) {
		this.people.add(person);
	}

	/**
	 * Removes the person.
	 *
	 * @param person
	 *            the person
	 */
	public void removePerson(Person person) {
		this.people.remove(person);
	}

}
