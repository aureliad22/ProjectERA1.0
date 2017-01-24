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
//	ArrayList<Homework>homework;
	
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
	 * @param userName
	 * @param firstName
	 * @param lastName
	 */
	public Student(String email, String userName, String firstName, String lastName, String password) {
		super(email, userName, firstName, lastName, password);
//		this.grade = grade;
//		this.homework = homework;
	}

	
}
