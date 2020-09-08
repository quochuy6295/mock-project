package com.vti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Team;
import com.vti.repository.ITeamRepository;

@Service
public class TeamServices implements ITeamServices {

	@Autowired
	private ITeamRepository repository;

	@Override
	public List<Team> getAllTeam(Pageable pageRequest) {
		Page<Team> pageResult = repository.findAll(pageRequest);
		return pageResult.getContent();
	}

	public Team getTeamById(int id) {
		return repository.findById(id);
	}

	public void createTeam(Team team) {
		repository.save(team);
	}

	public void updateTeam(Team team) {
		repository.save(team);
	}

	public void deleteTeam(int id) {
		repository.deleteById(id);
	}

	public boolean existsByName(String name) {
		return repository.existsByName(name);
	}
}
