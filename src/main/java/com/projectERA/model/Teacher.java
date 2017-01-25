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

//	@ManyToMany
//	private List<Subject> subjects;
	
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
	 * @param login
	 * @param firstName
	 * @param lastName
	 * @param subjects
	 */
	public Teacher(String email, String login, String firstName, String lastName, String password, int category) {
		super(email, login, firstName, lastName, password, 1);
//		this.subjects = new ArrayList<Subject>();;
	}

	/**
	 * @return the subjects
	 */
//	public List<Subject> getSubjects() {
//		return subjects;
//	}

	/**
	 * @param subjects the subjects to set
	 */
//	public void setSubjects(List<Subject> subjects) {
//		this.subjects = subjects;
//	}

}