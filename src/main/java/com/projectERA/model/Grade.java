package com.projectERA.model;

import java.time.Year;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.projectERA.model.base.EntityBase;

@Entity
@Table(name = "grades")
@Inheritance
public class Grade extends EntityBase {
	
	@NotNull
	private String name;
	
	@NotNull
	private Year year;
	
	
	public Grade(){		
	}

	public Grade(Integer id){
		super(id);
	}

	public Grade(String name, Year year) {
		this.name = name;
		this.year = year;
	}
	/**
	 * @param idPromo
	 * @param name
	 * @param year
	 */
	public Grade(Integer id, String name, Year year) {
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
	public Year getYear() {
		return year;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(Year year) {
		this.year = year;
	}
}
