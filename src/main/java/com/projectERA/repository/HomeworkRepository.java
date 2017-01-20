package com.projectERA.repository;

import org.springframework.data.repository.CrudRepository;

import com.projectERA.model.Homework;

public interface HomeworkRepository extends CrudRepository<Homework, Long>{

	//Homework findByUserName(String userName);

}
