package com.projectERA.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.projectERA.model.base.EntityBase;

@Entity
@Table(name = "group")
public class Group extends EntityBase{
	
	public Group(){		
	}	
	
	/**
	 * @param idGroupe
	 */
	public Group(int id) {
		super(id);
	}

	public void create(){
		
	}
	public void modify(){
		
	}

}
