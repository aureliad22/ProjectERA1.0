package com.projectERA.repository;

import org.springframework.data.repository.CrudRepository;

import com.projectERA.model.Archive;

public interface ArchiveRepository extends CrudRepository<Archive, Long>{

	//Archive findByUserName(String userName);

}
