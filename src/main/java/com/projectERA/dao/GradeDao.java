package com.projectERA.dao;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.IGradeDao;
import com.projectERA.model.Grade;

public class GradeDao extends BaseDao<Grade> implements IGradeDao{

	@Override
	public Grade getById(int id){
		return super.entityManager.find(Grade.class, id);
	}
}