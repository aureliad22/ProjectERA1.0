/**
 * 
 */
package com.projectERA.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

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
	 * @param userName
	 * @param firstName
	 * @param lastName
	 */
	public Teacher(String email, String login, String firstName, String lastName, String password) {
		super(email, login, firstName, lastName, password);
	}

}