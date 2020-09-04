package com.vti.services;

import java.util.List;

import com.vti.entity.User;

public interface IUserServices {
	public List<User> getAllUser();
	
	public User getUserByuserName(String userName);
	
	public void createUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
	public boolean isUserexistsByuserName(String userName);
}
