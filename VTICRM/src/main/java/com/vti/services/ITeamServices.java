package com.vti.services;

import java.util.List;

import com.vti.entity.Team;

public interface ITeamServices {
	
	public List<Team> getAllTeam();
	
	public Team getTeamById(int id);
	
	public void createTeam(Team team);
	
	public void updateTeam(Team team);
	
	public void deleteTeam(int id);
	
	public boolean existsByName(String name);
}
