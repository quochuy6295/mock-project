package vn.com.vti_crm.web.controller;

import java.net.URISyntaxException;
import java.util.Optional;

import javax.xml.crypto.URIReferenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.com.vti_crm.domain.User;
import vn.com.vti_crm.service.UserService;
import vn.com.vti_crm.web.rest.UserResource;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/users/{userId}/join-team/{teamId}", method = RequestMethod.POST)
	public ResponseEntity<?> updateUserTeam(@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "teamId") Integer teamId) throws URISyntaxException {
		log.debug("REST request to save an user to a team: userId: {}, teamId: {}", userId, teamId);
		Optional<User> user = userService.updateUserTeam(teamId, userId);
		return user.map(u -> new ResponseEntity<>(user.get(), HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@RequestMapping(value = "/users/{userId}/leave-team/{teamId}", method = RequestMethod.POST)
	public ResponseEntity<?> removeUserTeam(@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "teamId") Integer teamId) throws URISyntaxException, URIReferenceException {
		log.debug("REST request to remove an user from a team: userId: {}, teamId: {}", userId, teamId);
		Optional<User> user = userService.removeUserTeam(teamId, userId);
		return user.map(u -> new ResponseEntity<>(user.get(), HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
