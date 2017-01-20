package com.projectERA.repository;

import org.springframework.data.repository.CrudRepository;

import com.projectERA.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User getByEmail(String email);

	User getById(int id);

	User findByUserName(String userName);
}
