package com.projectERA.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import com.projectERA.model.base.EntityBase;

@Entity
@Table(name = "groups")
@Inheritance
public class Group extends EntityBase{
	
	public Group(){		
	}	
	
	/**
	 * @param id
	 */
	public Group(Integer id) {
		super(id);
	}

	public void create(){
		
	}
	public void modify(){
		
	}

//	public void AjouterAuteur(Teacher t){
//		if (authors.size() < 2) {
//			authors.add(t);
//			System.out.println(t.getLastName() + " a �t� ajout� en tant qu'auteur");
//		} else {
//			System.out.println("err taille max d'auteurs");
//		}		
//	}
//	
//	public void RetirerAuteur(Teacher t){
//		if (authors.size() > 1) {
//			authors.remove(t);
//			System.out.println(t.getLastName() + " a �t� retir� de la liste d'auteurs");
//		} else {
//			System.out.println("plus d'auteur pour le [" +  title + "]. Dernier enseignant : " + t.getLastName());
//		}		
//	}
}
