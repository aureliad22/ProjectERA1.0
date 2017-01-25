package com.projectERA.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import com.projectERA.model.base.EntityBase;

@Entity
@Table(name = "groups")
@Inheritance
public class Group extends EntityBase{
	
	public Group(){		
	}	
	
	/**
	 * @param id
	 */
	public Group(Integer id) {
		super(id);
	}

	public void create(){
		
	}
	public void modify(){
		
	}

}
