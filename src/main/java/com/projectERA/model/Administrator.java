/**
 * 
 */
package com.projectERA.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Administrator entity
 * @author aureliadelaune
 */
@Entity
@Table(name = "administrator")
public class Administrator extends User {

	/**
	 * public methods
	 */
	public Administrator(){
		
	}
	
	/**
	 * @param id from EntityBase
	 */
	public Administrator(int id) {
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
	public Administrator(int id, String email, String userName, String firstName, String lastName, String password,
			byte[] guid) {
		super(id, email, userName, firstName, lastName, password, guid);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Administrator [" + super.toString() + "]";
	}
}
