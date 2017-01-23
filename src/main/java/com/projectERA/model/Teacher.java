/**
 * 
 */
package com.projectERA.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Teacher entity
 */
@Entity
@Table(name = "teachers")
public class Teacher extends User {

	@Transient
	private List<Subject> subjects;
	
	/**
	 * public methods
	 */
	public Teacher() {
	}

	/**
	 * @param id from EntityBase
	 */
	public Teacher(int id) {
		super(id);
	}

	/**
	 * @param id
	 * @param email
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param guid
	 */
	public Teacher(int id, String email, String userName, String firstName, String lastName, String password,
			byte[] guid) {
		super(id, email, userName, firstName, lastName, password, guid);
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