package com.projectERA.dao.interfaces;

import org.springframework.stereotype.Repository;

import com.projectERA.dao.interfaces.base.IBaseDao;
import com.projectERA.model.Teacher;

@Repository
public interface ITeacherDao extends IBaseDao<Teacher>{

	Teacher getByEmail(String email);

	Teacher getByLogin(String login);

}
