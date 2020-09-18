package vn.com.vti_crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.com.vti_crm.domain.User;

@Service
public interface UserService {

	public User createUser(User user);

	public Optional<User> getUserById(int id);

	public Optional<User> updateUserTeam(int teamId, int userId);

	public Optional<User> removeUserTeam(int teamId, int userId);

	public List<User> getAllUsers();

	public void deleteUser(User user);

	public User updateUser(User user);

}
