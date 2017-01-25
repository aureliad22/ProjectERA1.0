package com.projectERA.dao;

import javax.transaction.Transactional;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.ISubjectDao;
import com.projectERA.model.Subject;
@Transactional
public class SubjectDao extends BaseDao<Subject> implements ISubjectDao
{

	@Override
	public Subject getById(Integer id){
		return super.entityManager.find(Subject.class, id);
	}
}
