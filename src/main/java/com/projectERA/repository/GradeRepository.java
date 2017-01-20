package com.projectERA.repository;

import org.springframework.data.repository.CrudRepository;

import com.projectERA.model.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long>{

	//Grade findByUserName(String userName);

}
