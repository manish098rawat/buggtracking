package com.bug.tracking.service;


import com.bug.tracking.modal.UserEntity;

public interface UserService {
	public UserEntity saveOrUpdate(UserEntity user);
	public UserEntity findUserById(Long id);
	public Iterable<UserEntity> findAllUser();
	public void deleteUserById(Long id);

}
