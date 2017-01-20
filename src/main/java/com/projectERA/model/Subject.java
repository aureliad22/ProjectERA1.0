package com.projectERA.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.projectERA.model.base.EntityBase;

@Entity
@Table(name = "subjects")
public class Subject extends EntityBase{
	
	@NotNull
	private String title;
	
	@NotNull
	private Date deadline;
	
	@NotNull
	private int groupSize; 
	
	@NotNull
	private String description;
	
	@NotNull
	private String specialty;
	
	private Date createAt;
	private int idPromo;


	private ArrayList<Teacher> authors;
	private ArrayList<Homework> homework = new ArrayList<Homework>();
	
	public Subject(){		
	}

	public Subject(int id){
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
	public Subject(int id, String title, Date deadline, int groupSize, String description,
			int idPromo, String specialty, ArrayList<Teacher> Authors) {
		super(id);	
		this.title = title;
		this.deadline = deadline;
		this.groupSize = groupSize;
		this.description = description;
		this.idPromo = idPromo;
		this.specialty= specialty;
		this.createAt= new Date();
		this.authors=Authors;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Subject [title=" + title + ", deadline=" + deadline + ", groupSize=" + groupSize + ", description="
				+ description + ", idPromo=" + idPromo + ", specialty=" + specialty + ", createAt=" + createAt
				+ ", authors=" + authors + ", homework=" + homework + ", toString()=" + super.toString() + "]";
	}

	public void createSubject(){
		
	}
	
	public void consultSubject(){
		
	}
	
	public void updateSubject(){
		
	}
	
	public void AjouterAuteur(Teacher t){
		if (authors.size() < 2) {
			authors.add(t);
			System.out.println(t.getLastName() + " a �t� ajout� en tant qu'auteur");
		} else {
			System.out.println("err taille max d'auteurs");
		}		
	}
	
	public void RetirerAuteur(Teacher t){
		if (authors.size() > 1) {
			authors.remove(t);
			System.out.println(t.getLastName() + " a �t� retir� de la liste d'auteurs");
		} else {
			System.out.println("plus d'auteur pour le [" +  title + "]. Dernier enseignant : " + t.getLastName());
		}		
	}
	
	
	public void deleteSubject(){
		
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
	 * @return the idPromo
	 */
	public int getIdPromo() {
		return idPromo;
	}


	/**
	 * @param idPromo the idPromo to set
	 */
	public void setIdPromo(int idPromo) {
		this.idPromo = idPromo;
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

	public void downloadHomework() {
		// TODO Auto-generated method stub
	//	task = new task 
	}


	
	
	
	
	
	
	
	

}
