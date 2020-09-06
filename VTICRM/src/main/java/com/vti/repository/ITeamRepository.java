package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Team;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer>{
	
	public Team findById(int id);
	
	public boolean existsByName(String name);
}
