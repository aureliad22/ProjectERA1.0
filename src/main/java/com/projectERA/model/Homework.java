package com.projectERA.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.projectERA.model.base.EntityBase;


@Entity
@Table(name = "homework")
public class Homework extends EntityBase{
	
	private String title;	
	private Date deposedAt;
	private String document;
	
	public Homework(){		
	}
	
	public Homework(Integer id){
		super(id);
	}
	
	public Homework(Integer id, String title, String document) {
		super(id);
		this.title = title;
		this.document = document;
		this.deposedAt = new Date();
	}
	
	public void addDocument(){
		
		
	}
	public void deleteDocument(){
		
	}
	public void consult(){
		
	}
	public void download(){
		
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
	 * @return the deposedAt
	 */
	public Date getDeposedAt() {
		return deposedAt;
	}

	/**
	 * @param deposedAt the deposedAt to set
	 */
	public void setDeposedAt(Date deposedAt) {
		this.deposedAt = deposedAt;
	}

	/**
	 * @return the documents
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocument(String documents) {
		this.document = documents;
	}

}
