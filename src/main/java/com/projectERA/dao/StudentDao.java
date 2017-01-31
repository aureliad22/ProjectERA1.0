package com.projectERA.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.IStudentDao;
import com.projectERA.model.Student;

@Service
@Transactional
public class StudentDao extends BaseDao<Student> implements IStudentDao{

	@Override
	public Student getById(Integer id){
		return super.entityManager.find(Student.class, id);
	}
	/**
	 * Return the student having the passed email.
	 */
	public Student getByEmail(String email) {
		Student s = null;
		List<Student>students = entityManager.createQuery("select S from Student S where S.email = :email", Student.class)
				.setParameter("email", email).getResultList();
				if(!students.isEmpty()){
					s=students.get(0);
				}
				return s;
	}
	
	public List getAll() {
		return entityManager.createQuery("select S from Student S").getResultList();
	}
}
