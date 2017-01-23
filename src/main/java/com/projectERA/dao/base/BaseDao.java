package com.projectERA.dao.base;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseDao <T>{
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public void create(T item) {
		entityManager.persist(item);		
	}
	
	public void delete(T item){
		entityManager.remove(item);
	}
	
	public List getAll(){
		return entityManager.createQuery("from Subject").getResultList();
	}
	
	public void update(T item){
		entityManager.merge(item);
	}
	
}
