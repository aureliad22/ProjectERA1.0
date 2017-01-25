package com.projectERA.dao;

import javax.transaction.Transactional;

import com.projectERA.dao.base.BaseDao;
import com.projectERA.dao.interfaces.IGroupDao;
import com.projectERA.model.Group;

@Transactional
public class GroupDao extends BaseDao<Group> implements IGroupDao
{

	@Override
	public Group getById(Integer id){
		return super.entityManager.find(Group.class, id);
	}

	


	}

