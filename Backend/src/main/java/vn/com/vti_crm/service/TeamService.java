package vn.com.vti_crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.vti_crm.domain.Team;

@Service
public interface TeamService {

	public Team createTeam(Team team);

	public List<Team> getAllTeam();

}
