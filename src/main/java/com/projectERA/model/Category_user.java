/**
 * 
 */
package com.projectERA.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.projectERA.model.base.EntityBase;

/**
 * Category_user entity
 * @author aureliadelaune
 *
 */
//@Entity
//@Table(name = "category of users")
public class Category_user extends EntityBase{
	
//	@NotNull
	private String categoryUser;
	
	/**
	 * Default constructor for Category_use entity.
	 */
	public Category_user() {
	}

	public Category_user(int id){
		super(id);
	}
	/**
	 * Full constructor for the Category_user entity, with:
	 * @param id
	 * @param categoryUser
	 */
	public Category_user(int id, String categoryUser) {
		super(id);
		this.categoryUser = categoryUser;
		
	}

	/**
	 * @return the categoryUser
	 */
	public String getCategoryUser() {
		return categoryUser;
	}

	/**
	 * @param categoryUser the categoryUser to set
	 */
	public void setCategoryUser(String categoryUser) {
		this.categoryUser = categoryUser;
	}
	
	
}
