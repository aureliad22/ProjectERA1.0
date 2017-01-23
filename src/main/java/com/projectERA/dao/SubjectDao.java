package com.projectERA.dao;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.ISubjectDao;
import com.projectERA.model.Subject;

public class SubjectDao extends BaseDao<Subject> implements ISubjectDao{

	@Override
	public Subject getById(int id){
		return super.entityManager.find(Subject.class, id);
	}
}
