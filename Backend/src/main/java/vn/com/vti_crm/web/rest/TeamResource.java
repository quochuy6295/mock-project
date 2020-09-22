package vn.com.vti_crm.web.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.com.vti_crm.domain.Team;
import vn.com.vti_crm.service.TeamService;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class TeamResource {

	private final Logger log = LoggerFactory.getLogger(TeamResource.class);

	@Autowired
	TeamService teamService;

	@RequestMapping(value = "/teams", method = RequestMethod.POST)
	public ResponseEntity<?> createTeam(@Valid @RequestBody Team team) throws URISyntaxException {
		log.debug("REST request to save Team : {}", team);
		team = teamService.createTeam(team);
		return new ResponseEntity<Team>(team, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public ResponseEntity<?> getAllTeam() {
		List<Team> teams = teamService.getAllTeam();
		return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
	}
}
