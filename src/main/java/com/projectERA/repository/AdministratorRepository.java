package com.projectERA.repository;

import org.springframework.data.repository.CrudRepository;

import com.projectERA.model.Administrator;

public interface AdministratorRepository extends CrudRepository<Administrator, Long>{

	Administrator findOne(Long id);

}
