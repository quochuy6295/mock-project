package com.vti.services;

import java.util.List;

import com.vti.entity.User;

public interface IUserServices {
	public List<User> getAllUser(Integer pageNo, Integer pageSize, String sortBy);

	public User getUserByuserName(String userName);

	public User addUser(User user);
	
//	public User createUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);

	public boolean isUserexistsByuserName(String userName);
}
