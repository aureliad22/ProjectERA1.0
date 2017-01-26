package com.projectERA.dao;

import javax.transaction.Transactional;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.IStudentDao;
import com.projectERA.model.Student;

@Transactional
public class StudentDao extends BaseDao<Student> implements IStudentDao{

	@Override
	public Student getById(Integer id){
		return super.entityManager.find(Student.class, id);
	}
	/**
	 * Return the teacher having the passed email.
	 */
	public Student getByEmail(String email) {
		return (Student) entityManager.createQuery("select * from Student where email = :email")
				.setParameter("email", email)
				.getSingleResult();
	}
}
