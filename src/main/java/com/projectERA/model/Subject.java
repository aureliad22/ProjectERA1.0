package com.projectERA.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.projectERA.model.base.EntityBase;

@Entity
@Table(name = "subjects")
@Inheritance
public class Subject extends EntityBase{
	
	@Column(name="title", nullable=false)
	private String title;
		
	@Column(name="creationDate", nullable=false)
	private Date createAt;
	
	@Column(name="deadline", nullable=false)
	private Date deadline;
	
	@Column(name="groupSize", nullable=false)
	private int groupSize; 
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="specialty", nullable=false)
	private String specialty;
	
	//many subjects for 1 author.
	@ManyToOne
	private Teacher author;
	
	//many subjects for many grades. Grade is the owner.
	@ManyToOne
	private Grade grade;

	//1 subject has many homework
//	@OneToMany
	private ArrayList<Homework> homework = new ArrayList<Homework>();
	
	public Subject(){		
	}

	public Subject(Integer id){
		super(id);
	}
	
	/**
	 * @param idSubject
	 * @param title
	 * @param deadline
	 * @param idgroupe
	 * @param description
	 * @param idPromo
	 */
	public Subject(Integer id, String title, Date deadline, Integer groupSize, String description,
			Grade grade, String specialty, Teacher author) {
		super(id);	
		this.title = title;
		this.deadline = deadline;
		this.groupSize = groupSize;
		this.description = description;
		this.setGrade(grade);
		this.specialty = specialty;
		this.createAt = new Date();
		this.author = author;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Subject [title=" + title + ", deadline=" + deadline + ", groupSize=" + groupSize + ", description="
				+ description + ", Grade=" + grade + ", specialty=" + specialty + ", createAt=" + createAt
				+ ", teacher=" + author + ", homework=" + homework + ", toString()=" + super.toString() + "]";
	}

	
	public void consultSubject(){
		
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the deadline
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	/**
	 * @return the groupSize
	 */
	public int getGroupSize() {
		return groupSize;
	}

	/**
	 * @param groupSize the groupSize to set
	 */
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the specialty
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
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

}
