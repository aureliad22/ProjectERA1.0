package com.projectERA.dao.interfaces;

import org.springframework.stereotype.Repository;

import com.projectERA.dao.interfaces.base.IBaseDao;
import com.projectERA.model.Student;

@Repository
public interface IStudentDao extends IBaseDao<Student>{

	Student getByEmail(String email);

	Student getByLogin(String login);

}
