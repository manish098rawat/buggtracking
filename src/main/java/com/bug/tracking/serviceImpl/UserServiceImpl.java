package com.bug.tracking.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.tracking.exception.UserIdException;
import com.bug.tracking.modal.UserEntity;
import com.bug.tracking.repository.UserRepository;
import com.bug.tracking.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserEntity saveOrUpdate(UserEntity user) {
		// TODO Auto-generated method stub
		try{
			return userRepository.save(user);
		}catch(Exception ex) {
			throw new UserIdException("User Id : "+ user.getId() +"already exists");
		}
		
	}
	@Override
	public UserEntity findUserById(Long id) {
		UserEntity user=userRepository.findUserById(id);
		if(user == null)
			throw new UserIdException("User Id " + id +" does not exist");
		return user;
	}
	@Override
	public Iterable<UserEntity> findAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	@Override
	public void deleteUserById(Long id) {
		UserEntity user = userRepository.findUserById(id);
		if(user == null)
			throw new UserIdException("User Id " + id +" does not exist");
		userRepository.delete(user);
		
	}
}
