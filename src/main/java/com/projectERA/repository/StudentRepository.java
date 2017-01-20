package com.projectERA.repository;

import org.springframework.data.repository.CrudRepository;

import com.projectERA.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

	Student findByUserName(String userName);

}
