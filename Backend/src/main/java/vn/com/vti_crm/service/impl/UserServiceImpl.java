package vn.com.vti_crm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.vti_crm.domain.Team;
import vn.com.vti_crm.domain.User;
import vn.com.vti_crm.repository.TeamRepository;
import vn.com.vti_crm.repository.UserRepository;
import vn.com.vti_crm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	UserService userService;

	@Override
	public User createUser(User user) {
		user = userRepository.save(user);
//		userService.updateUserTeam(user.getTeam().getId(), user.getId());
		return user;
	}

	@Override
	public Optional<User> getUserById(int id) {
		return userRepository.findUserById(id);
	}

	@Override
	public Optional<User> updateUserTeam(int teamId, int userId) {
		Optional<User> user = userRepository.findUserById(userId);
		if (user.isPresent()) {
			Optional<Team> team = teamRepository.findTeamById(teamId);
			if (team.isPresent()) {
				user.get().setTeam(team.get());
				userRepository.save(user.get());
			}
		}

		return user;
	}

	@Override
	public Optional<User> removeUserTeam(int teamId, int userId) {
		Optional<User> user = userRepository.findUserById(userId);
		if (user.isPresent()) {
			Optional<Team> team = teamRepository.findTeamById(teamId);
			if (team.isPresent()) {
				user.get().setTeam(null);
			}
		}

		return user;

	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();

	}

	@Override
	public void deleteUser(User user) {
		userRepository.save(user);

	}

	@Override
	public User updateUser(User user) {
		user = userRepository.save(user);
		userService.updateUserTeam(user.getTeam().getId(), user.getId());
		return user;
	}

}
