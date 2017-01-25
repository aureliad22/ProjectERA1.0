package com.projectERA.model;





import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import com.projectERA.model.base.EntityBase;


@Entity
@Table(name = "homework")
@Inheritance
public class Homework extends EntityBase{

	@Column(name="title")
	private String title;
	
	@Column(name="creationDate")
	private Date droppedAt;
	
	@Column(name="document")
	private String document;
	
	/**
	 * public methods.
	 */
	public Homework(){		
	}
	
	public Homework(Integer id){
		super(id);
	}
	
	public Homework(Integer id, String title,String document) {
		super(id);
		this.title = title;
		this.document = document;
		this.droppedAt = new Date();
	}
	
	/**
	 * Drop the homework in the dropbox.
	 */
	public void addDocument(){
		
		
	}
	
	/**
	 * Delete the dropped homework.
	 */
	public void deleteDocument(){
		
	}
	
	/**
	 * Consult the dropped homework.
	 */
	public void consult(){
		
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
		return droppedAt;
	}

	/**
	 * @param deposedAt the deposedAt to set
	 */
	public void setDeposedAt(Date deposedAt) {
		this.droppedAt = deposedAt;
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
