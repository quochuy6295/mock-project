package com.vti.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.reflect.TypeToken;
import com.vti.dto.TeamDto;
import com.vti.entity.Team;
import com.vti.services.ITeamServices;

@RestController
@RequestMapping(value = "api/v1/teams")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TeamController {

	@Autowired
	private ITeamServices services;

	@Autowired
	private ModelMapper modelMapper;

	@SuppressWarnings("serial")
	@GetMapping()
	public ResponseEntity<?> getAllTeams(Pageable pageRequest) {
		// get data
		List<Team> entities = services.getAllTeam(pageRequest);
		// convert dto
		Type type = new TypeToken<List<TeamDto>>() {
		}.getType();
		List<TeamDto> dtos = modelMapper.map(entities, type);
		return new ResponseEntity<List<TeamDto>>(dtos, HttpStatus.OK);
	}

	@SuppressWarnings("serial")
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getTeamById(@PathVariable(name = "id") int id) {
		// get data
		Team entities = services.getTeamById(id);
		// convert dto
		Type type = new TypeToken<TeamDto>() {
		}.getType();
		TeamDto dtos = modelMapper.map(entities, type);
		return new ResponseEntity<TeamDto>(dtos, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createTeam(@RequestBody Team team) {
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
