package com.projectERA.dao;

import javax.transaction.Transactional;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.ITeacherDao;
import com.projectERA.model.Teacher;

@Transactional
public class TeacherDao extends BaseDao<Teacher> implements ITeacherDao {
	/**
	 * Return the teacher having the passed id.
	 */
	@Override
	public Teacher getById(Integer id) {
		return super.entityManager.find(Teacher.class, id);
	}

	/**
	 * Return the teacher having the passed email.
	 */
	public Teacher getByEmail(String email) {
		return (Teacher) entityManager.createQuery("from Teacher where email = :email").setParameter("email", email)
				.getSingleResult();
	}
}
