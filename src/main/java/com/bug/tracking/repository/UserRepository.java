package com.bug.tracking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bug.tracking.modal.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{

	UserEntity findUserById(Long id);
	List<UserEntity> findAll();
}
