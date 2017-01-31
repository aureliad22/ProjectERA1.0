package com.projectERA.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.ITeacherDao;
import com.projectERA.model.Teacher;

@Service 
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
		Teacher t = null;
		List<Teacher>teachers = entityManager.createQuery("select T from Teacher T where T.email = :email", Teacher.class)
				.setParameter("email", email).getResultList();
		if(!teachers.isEmpty()){
			t=teachers.get(0);
		}
		return t;
	}
	
	public Teacher getByLogin(String login) {
		Teacher t = null;
		List<Teacher> result= entityManager.createQuery("SELECT T FROM  Teacher T where T.login = :login", Teacher.class)
                .setParameter("login", login).getResultList();
		  if (!result.isEmpty()){
			  t=result.get(0);
		  }
		  return t;
	}
	
	public List getAll() {
		return entityManager.createQuery("select T from Teacher T").getResultList();
	}
	
//	/**
//	 * Return the teacher having the passed lastname.
//	 */
//	public Teacher getByName(String lastName) {
//		  return (Teacher) entityManager.createQuery("select T from Teacher where T.lastname = :lastName")
//				  .setParameter("lastname", lastName).getSingleResult();
//	}
}
