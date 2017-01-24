package com.projectERA.manager.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectERA.dao.interfaces.base.IBaseDao;

@Service
public abstract class BaseManager<T> {

	@Autowired
	private IBaseDao<T> dao;
	
	public void create(T item) {
		dao.create(item);
	}


	public void delete(T item) {
		dao.delete(item);
	}


	public List getAll() {
		return dao.getAll();
	}


	public T getById(Integer id) {
		return dao.getById(id);
	}


	public void update(T item) {
		dao.update(item);
	}

}
