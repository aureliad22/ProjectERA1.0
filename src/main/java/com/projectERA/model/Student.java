package com.projectERA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student extends User{

	@Column
	private int promoId;
	
	@Column
	private int groupID;
	
	public Student(){ 
	}

	public Student(int id){
		super(id);
	}


	/**
	 * @param email
	 * @param userName
	 * @param firstName
	 * @param lastName
	 */
	public Student(String email, String userName, String firstName, String lastName) {
		super(email, userName, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [" + super.toString() + "]";
	}

	/**
	 * @return the promoId
	 */
	public int getPromoId() {
		return promoId;
	}

	/**
	 * @param promoId the promoId to set
	 */
	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}

	/**
	 * @return the groupID
	 */
	public int getGroupID() {
		return groupID;
	}

	/**
	 * @param groupID the groupID to set
	 */
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	
	
}
	