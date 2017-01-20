package com.projectERA.repository;

import org.springframework.data.repository.CrudRepository;

import com.projectERA.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long>{

	//Subject findByUserName(String userName);

}
