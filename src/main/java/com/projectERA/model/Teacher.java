/**
 * 
 */
package com.projectERA.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Teacher entity
 * 
 * @author aureliadelaune
 *
 */
@Entity
@Table(name = "teachers")
public class Teacher extends User {

	/**
	 * constructor by default for the Teacher entity
	 */
	public Teacher() {
	}

	public Teacher(int id) {
		super(id);
	}

	/**
	 * @param email
	 * @param userName
	 * @param firstName
	 * @param lastName
	 */
	public Teacher(String email, String userName, String firstName, String lastName) {
		super(email, userName, firstName, lastName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Teacher [" + super.toString() + "]";
	}

	/**
	 * downloadHomework method
	 */
	public void downloadHomework() {

	}

}