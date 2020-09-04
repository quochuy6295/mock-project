package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Team;
import com.vti.services.ITeamServices;

@RestController
@RequestMapping(value = "api/v1/teams")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TeamController {
	
	@Autowired
	private ITeamServices services;
	
	@GetMapping()
	public ResponseEntity<?> getAllTeams(){
		//get data
		List<Team> entities =services.getAllTeam();
		return new ResponseEntity<List<Team>>(entities, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getTeamById(@PathVariable(name = "id")int id){
		return new ResponseEntity<Team>(services.getTeamById(id), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> createTeam(@RequestBody Team team){
		services.createTeam(team);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateTeam(@PathVariable(name = "id") int id, @RequestBody Team team) {
		team.setId(id);
		services.updateTeam(team);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteTeam(@PathVariable(name = "id") int id) {
		services.deleteTeam(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
