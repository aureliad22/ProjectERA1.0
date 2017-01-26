package com.projectERA.dao.base;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseDao <T>{
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	/**
	 * Save the item in the database
	 * @param item
	 */
	public void create(T item) {
		entityManager.persist(item);		
	}
	
	/**
	 * Delete the item from the database
	 * @param item
	 */
	public void delete(T item){
		entityManager.remove(item);
	}
	
	/**
	 * Return all the items from a table in the database
	 * @return
	 */
	public List getAll(){
		return entityManager.createQuery("Select * from T").getResultList();
	}
	
	/**
	 * Update the identified item in the database
	 * @param item
	 */
	public void update(T item){
		entityManager.merge(item);
	}
	
}
