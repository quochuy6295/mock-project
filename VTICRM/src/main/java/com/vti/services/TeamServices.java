package com.vti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Team;
import com.vti.repository.ITeamRepository;

@Service
public class TeamServices implements ITeamServices{
	
	@Autowired
	private ITeamRepository repository;
	
	public List<Team> getAllTeam(){
		return repository.findAll();
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
