package com.projectERA.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
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

	@Transient
	private String password;

	@NotNull
	private byte[] guid;

	/**
	 * Public methods
	 */
	public User() {
	}

	/**
	 * @param id from EntityBase
	 */
	public User(int id) {
		super(id);
	}

	/**
	 * @param email
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param guid
	 */
	public User(int id, String email, String userName, String firstName, String lastName, String password,
			byte[] guid) {
		super(id);
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.guid = guid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + super.toString() + "email=" + email + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", guid=" + Arrays.toString(guid) + "]";
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
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

	/**
	 * @return the guid
	 */
	public byte[] getGuid() {
		return guid;
	}

	/**
	 * @param guid
	 *            the guid to set
	 */
	public void setGuid(byte[] guid) {
		this.guid = guid;
	}

}
