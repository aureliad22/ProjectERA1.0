package com.projectERA.dao;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.ITeacherDao;
import com.projectERA.model.Teacher;

public class TeacherDao extends BaseDao<Teacher> implements ITeacherDao{

	@Override
	public Teacher getById(int id){
		return super.entityManager.find(Teacher.class, id);
	}
}