package com.projectERA.repository;

import org.springframework.data.repository.CrudRepository;

import com.projectERA.model.Group;

public interface GroupRepository extends CrudRepository<Group, Long>{

	//Group findByLogin(String login);
}

