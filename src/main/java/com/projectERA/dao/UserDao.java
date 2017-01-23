package com.projectERA.dao;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.IUserDao;
import com.projectERA.model.User;

public class UserDao extends BaseDao<User> implements IUserDao{

	@Override
	public User getById(int id){
		return super.entityManager.find(User.class, id);
	}

}