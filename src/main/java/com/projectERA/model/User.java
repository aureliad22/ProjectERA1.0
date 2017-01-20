package com.projectERA.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.projectERA.model.base.EntityBase;

@Entity
@Table(name = "users")
public class User extends EntityBase {

	// The entity fields (private)

	@NotNull
	private String email;

	@NotNull
	private String userName;

	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	private String password;

	// Public methods

	public User() {
	}

	public User(int id) {
		super(id);
	}

	public User(String email, String userName) {
		this.email = email;
		this.userName = userName;
	}

	public User(String email, String userName, String firstName, String lastName) {
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
