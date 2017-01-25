package com.projectERA.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name="students")
@Inheritance
public class Student extends User{

//	@ManyToOne
//	private Grade grade;
//	
//	@ManyToOne
//	private Group group;
//	
//	@OneToMany
//	List<Homework>homework;
	
	public Student(){ 
	}

	public Student(Integer id){
		super(id);
	}

	public Student(String email, String password){
		super(email, password);
	}

	/**
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public Student(String email, String firstName, String lastName) {
		super(email, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param email
	 * @param login
	 * @param firstName
	 * @param lastName
	 * @param grade
	 * @param group
	 * @param homework
	 */
	public Student(String email, String firstName, String lastName, String password, int category) {
		super(email, firstName, lastName);	
		this.setPassword("5tud3nt");
		this.setCategory(2);
		//this.homework = new ArrayList<Homework>();
	}
	
}
