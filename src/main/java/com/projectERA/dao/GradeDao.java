package com.projectERA.dao;

import javax.transaction.Transactional;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.IGradeDao;
import com.projectERA.model.Grade;

@Transactional
public class GradeDao extends BaseDao<Grade> implements IGradeDao{

	@Override
	public Grade getById(Integer id){
		return super.entityManager.find(Grade.class, id);
	}
	
}
