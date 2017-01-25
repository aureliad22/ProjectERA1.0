package com.projectERA.dao;

import javax.transaction.Transactional;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.IHomeworkDao;
import com.projectERA.model.Homework;
@Transactional
public class HomeworkDao extends BaseDao<Homework> implements IHomeworkDao
{

	@Override
	public Homework getById(Integer id){
		return super.entityManager.find(Homework.class, id);
	}
}
