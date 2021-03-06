package com.projectERA.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="students")
@Inheritance
public class Student extends User{

	//many students in 1 grade.
	@ManyToOne
	private Grade grade;
	
	//many students in 1 group.
	@ManyToOne
	private Group group;
	
	//1 student has many homework.
	@OneToMany
	private List<Homework>homework;
	
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
	public Student(String email, String firstName, String lastName, String login, String ldapGUID) {
		super(email, firstName, lastName, login, ldapGUID);
		this.setPassword("stud3nt");
		this.setCategory(2);
		this.homework = new ArrayList<Homework>();
	}

	/**
	 * @param email
	 * @param login
	 * @param firstName
	 * @param lastName
	 * @param subjects
	 */
	public Student(
			@JsonProperty("email") 
			String email, 
			@JsonProperty("firstName") 
			String firstName, 
			@JsonProperty("lastName") 
			String lastName, 
			@JsonProperty("password") 
			String password, 
			@JsonProperty("login") 
			String login, 
			@JsonProperty("category") 
			int category, 
			@JsonProperty("ldapGUID") 
			String ldapGUID,
			@JsonProperty("grade")
			Grade grade,
			@JsonProperty("group")
			Group group) {
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);	
		this.setLogin(login);
		this.setPassword(password);
		this.setCategory(category);
		this.setLdapGUID(ldapGUID);
		this.setGrade(grade);
		this.setGroup(group);
		this.homework= new ArrayList<Homework>();
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
	 * @return the homework
	 */
	public List<Homework> getHomework() {
		return homework;
	}

	/**
	 * @param homework the homework to set
	 */
	public void setHomework(List<Homework> homework) {
		this.homework = homework;
	}
	
}
