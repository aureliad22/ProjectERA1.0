package com.projectERA.dao;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.IStudentDao;
import com.projectERA.model.Student;

public class StudentDao extends BaseDao<Student> implements IStudentDao{

	@Override
	public Student getById(int id){
		return super.entityManager.find(Student.class, id);
	}
}
