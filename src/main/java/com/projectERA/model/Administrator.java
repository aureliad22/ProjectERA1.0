/**
 * 
 */
package com.projectERA.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

/**
 * Administrator entity
 * @author aureliadelaune
 */
//@Entity
//@Table(name = "administrator")
//@Inheritance
public class Administrator extends User {

	/**
	 * public methods
	 */
	public Administrator(){
		
	}
	
	/**
	 * @param id from EntityBase
	 */
	public Administrator(Integer id) {
		super(id);
	}


	/**
	 * @param email
	 * @param userName
	 * @param firstName
	 * @param lastName
	 */
	public Administrator(String email, String login, String firstName, String lastName, String password) {
		super(email, login, firstName, lastName, password);
	}
}
