package com.projectERA.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="students")
public class Student extends User{

	@NotNull
	private Grade grade;
	
	@Column
	private Group group;
	
	@Column
	private ArrayList<Homework> homework;
	
	/**
	 * public methods
	 */
	public Student(){ 
	}

	/**
	 * @param id from EntityBase
	 */
	public Student(int id){
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
	public Student(int id, String email, String userName, String firstName, String lastName, String password,
			byte[] guid) {
		super(id, email, userName, firstName, lastName, password, guid);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [" + super.toString() + "]";
	}

	/**
	 * @return the grade
	 */
	public Grade getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	/**
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * @return the homeworkList
	 */
	public ArrayList<Homework> getHomework() {
		return homework;
	}

	/**
	 * @param homeworkList the homeworkList to set
	 */
	public void setHomework(ArrayList<Homework> homework) {
		this.homework = homework;
	}

}
	