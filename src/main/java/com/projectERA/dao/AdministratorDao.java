package com.projectERA.dao;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.IAdministratorDao;
import com.projectERA.model.Administrator;

public class AdministratorDao extends BaseDao<Administrator> implements IAdministratorDao{

	@Override
	public Administrator getById(int id){
		return super.entityManager.find(Administrator.class, id);
	}
}
