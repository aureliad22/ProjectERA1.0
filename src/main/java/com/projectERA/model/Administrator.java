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
	 * constructor by default for the Administrator entity
	 */
	public Administrator(){
		
	}
	
	public Administrator(int id) {
		super(id);
	}

	/**
	 * full constructor for the Administrator entity, calling the User constructor, with:
	 * @param fname
	 * @param lname
	 * @param login
	 * @param password
	 * @param idAdmin
	 */
	public Administrator(String fname, String lname, String login, String password, int idAdmin) {
		super(fname, lname, login, password);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Administrator []";
	}
	
	
}
