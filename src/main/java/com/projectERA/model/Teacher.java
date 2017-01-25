/**
 * 
 */
package com.projectERA.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
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

	@ManyToMany
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public Teacher(String email, String firstName, String lastName) {
		super(email, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param email
	 * @param login
	 * @param firstName
	 * @param lastName
	 * @param subjects
	 */
	public Teacher(String email, String firstName, String lastName, String password, int category) {
		super(email, firstName, lastName);
		this.setPassword("t34ch3r");
		this.setCategory(1);
		this.subjects = new ArrayList<Subject>();;
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