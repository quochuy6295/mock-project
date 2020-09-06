package com.vti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.User;
import com.vti.repository.IUserRepository;

@Service
public class UserServices implements IUserServices{

	@Autowired
	private IUserRepository repository;
	
	public List<User> getAllUser(){
		return repository.findAll();
	}

	public User getUserByuserName(String userName) {
		return repository.findByuserName(userName);
	}
	
	public void createUser(User user) {
		repository.save(user);
	}
	
	public void updateUser(User user) {
		repository.save(user);
	}
	
	public void deleteUser(int id) {
		repository.deleteById(id);
	}
	
	public boolean isUserexistsByuserName(String userName) {
		return repository.existsByuserName(userName);
	}
}
