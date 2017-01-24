package com.projectERA.manager.interfaces.base;

import java.util.List;

public abstract interface IBaseManager <T> {
	public void create(T item);
	public void delete(T item);
	public List getAll();
	public T getById(Integer id);
	public void update(T item);
}
