package vn.com.vti_crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.vti_crm.domain.Team;
import vn.com.vti_crm.repository.TeamRepository;
import vn.com.vti_crm.repository.UserRepository;
import vn.com.vti_crm.service.TeamService;
import vn.com.vti_crm.service.UserService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Override
	public Team createTeam(Team team) {
		team = teamRepository.save(team);
		userService.updateUserTeam(team.getId(), team.getTeamLeadId());
		return team;
	}

	@Override
	public List<Team> getAllTeam() {
		return teamRepository.findAll();
	}

}
