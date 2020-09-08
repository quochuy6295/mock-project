package com.vti.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.vti.entity.Team;

public interface ITeamServices {

	public List<Team> getAllTeam(Pageable pageRequest);

	public Team getTeamById(int id);

	public void createTeam(Team team);

	public void updateTeam(Team team);

	public void deleteTeam(int id);

	public boolean existsByName(String name);
}
