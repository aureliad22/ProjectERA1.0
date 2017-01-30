package com.projectERA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projectERA.model.base.EntityBase;

@Entity
@Table(name = "grades")
@Inheritance
public class Grade extends EntityBase {
	
	@Column
	private String name;
	
	@Column
	private String year;
	
	
	public Grade(){		
	}

	public Grade(Integer id){
		super(id);
	}

	public Grade(@JsonProperty("name") String name, @JsonProperty("year") String year) {
		this.setName(name);
		this.setYear(year);
	}
	
	/**
	 * @param idPromo
	 * @param name
	 * @param year
	 */
	public Grade(Integer id, String name, String year) {
		super(id);
		this.name = name;
		this.year = year;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
}
