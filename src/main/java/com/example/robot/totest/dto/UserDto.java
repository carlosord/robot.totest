package com.example.robot.totest.dto;

/**
 * The Class UserDto.
 */
public class UserDto {
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/** The role. */
	private String role;
	
	/**
	 * Instantiates a new user dto.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public UserDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * Instantiates a new user dto.
	 *
	 * @param username the username
	 * @param password the password
	 * @param role the role
	 */
	public UserDto(String username, String password, String role) {
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
	 * @param username the new username
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
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}	

	
}
