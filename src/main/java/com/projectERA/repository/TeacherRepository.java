package com.projectERA.repository;

import org.springframework.data.repository.CrudRepository;

import com.projectERA.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long>{

	Teacher findByUserName(String userName);

}
