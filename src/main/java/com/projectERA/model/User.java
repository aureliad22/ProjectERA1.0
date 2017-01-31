package com.projectERA.model;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.projectERA.model.base.EntityBase;

@MappedSuperclass
@Inheritance
public abstract class User extends EntityBase {

	// The entity fields (private)

	@Column(name = "email")
	private String email;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "password")
	private String password;

	@Column(name = "category")
	private int category;

	@Column(name = "ldapGUID")
	private String ldapGUID;

	// Public methods

	public User() {
	}

	public User(Integer id) {
		super(id);
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User(String email, String firstName, String lastName) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String email, String firstName, String lastName, String ldapGUID) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ldapGUID = ldapGUID;
	}
	/**
	 * @param email
	 * @param login
	 * @param firstName
	 * @param lastName
	 * @param password
	 */
	public User(String email, String firstName, String lastName, String password, int category) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.category = category;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [" + super.toString() + "email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password 
				+ ", ldapGUID=" + ldapGUID 
				+ "]";
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
	 * the password to set
	 */
	 public void setPassword(String password) {
	 this.password = password;
	 }

	/**
	 * @return the categoryId
	 */
	public int getCategory() {
		return category;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategory(int category) {
		this.category = category;
	}

	/**
	 * @return the ldapGUID
	 */
	public String getLdapGUID() {
		return ldapGUID;
	}

	/**
	 * @param ldapGUID
	 *            the ldapGUID to set
	 */
	public void setLdapGUID(String ldapGUID) {
		this.ldapGUID = ldapGUID;
	}

}
