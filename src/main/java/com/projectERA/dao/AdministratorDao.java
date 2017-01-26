package com.projectERA.dao;

import javax.transaction.Transactional;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.IAdministratorDao;
import com.projectERA.model.Administrator;

@Transactional
public class AdministratorDao extends BaseDao<Administrator> implements IAdministratorDao
{

	@Override
	public Administrator getById(Integer id){
		return super.entityManager.find(Administrator.class, id);
	}

	public Administrator getByEmail(String email) {
		return (Administrator) entityManager.createQuery("select * from Administrator where email = :email")
				.setParameter("email", email)
				.getSingleResult();
	}
	
}
