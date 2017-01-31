/**
 * 
 */
package com.projectERA.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Teacher entity
 * 
 * @author aureliadelaune
 *
 */
@Entity
@Table(name = "teachers")
@Inheritance
public class Teacher extends User {

//	1 teacher has many subjects.
	@OneToMany
	private List<Subject> subjects;
	
	/**
	 * constructor by default for the Teacher entity
	 */
	public Teacher() {
		super();
	}

	public Teacher(Integer id) {
		super(id);
	}

	/**
	 * @param email
	 * @param password
	 */
	public Teacher(String email, String password) {
		super(email, password);
	}

	/**
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public Teacher(String email, String firstName, String lastName) {
		super(email, firstName, lastName);
	}

	/**
	 * @param email
	 * @param login
	 * @param firstName
	 * @param lastName
	 * @param subjects
	 */
	public Teacher(String email, String firstName, String lastName, String login, String ldapGUID) {
		super(email, firstName, lastName, login, ldapGUID);
		this.setPassword("t34ch3r");
		this.setCategory(1);
		this.subjects = new ArrayList<Subject>();;
	}

	/**
	 * @param email
	 * @param login
	 * @param firstName
	 * @param lastName
	 * @param subjects
	 */
	public Teacher(
			@JsonProperty("email") 
			String email, 
			@JsonProperty("firstName") 
			String firstName, 
			@JsonProperty("lastName") 
			String lastName, 
			@JsonProperty("login")
			String login,
			@JsonProperty("password") 
			String password, 
			@JsonProperty("category") 
			int category,
			@JsonProperty("ldapGUID") 
			String ldapGUID
			) {
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);	
		this.setLogin(login);
		this.setPassword(password);
		this.setCategory(category);
		this.setLdapGUID(ldapGUID);
		this.subjects= new ArrayList<Subject>();
	}
	
	/**
	 * @return the subjects
	 */
	public List<Subject> getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}